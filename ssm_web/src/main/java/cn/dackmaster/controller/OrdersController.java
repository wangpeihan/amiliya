package cn.dackmaster.controller;

import cn.dackmaster.domain.Orders;
import cn.dackmaster.domain.Product;
import cn.dackmaster.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1", required = true) int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size) throws Exception {
        ModelAndView mv = new ModelAndView ( );
        List <Orders> list = ordersService.findAll ( page, size );
        PageInfo pageInfo = new PageInfo ( list );
        mv.addObject ( "pageInfo", pageInfo );
        mv.setViewName ( "orders-list" );
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findAll(@RequestParam(name = "id", required = true) String id) throws Exception {
        ModelAndView mv = new ModelAndView ( );
        Orders orders = ordersService.findById ( id );
        mv.addObject ( "orders",orders );
        mv.setViewName ( "orders-show" );
        return mv;

    }

}