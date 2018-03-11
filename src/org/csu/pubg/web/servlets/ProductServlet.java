package org.csu.pubg.web.servlets;

import org.csu.pubg.domain.Category;
import org.csu.pubg.domain.Classification;
import org.csu.pubg.domain.Item;
import org.csu.pubg.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liulin on 2017/9/21.
 */
@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final String VIEW_PRODUCT="WEB-INF/jsp/cart/Product.jsp";
    int itemId;
    ProductService productService;
    Item item;
    List<Classification> categoryList;
    List<Category> nowCategoryList;
    Category nowCategory;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productService=new ProductService();
        item=new Item();
        HttpSession session=request.getSession();
        categoryList=new ArrayList<Classification>();
        nowCategoryList=new ArrayList<>();
        List<Item> nowItemList=new ArrayList<>();

        itemId= Integer.parseInt(request.getParameter("itemId"));
        item=productService.getItemByItemId(itemId);
        categoryList=productService.getCategoryIdbyItemId(itemId);

        //根据选中的类别，得到同类别的商品集
        for(Classification classification:categoryList){
            nowCategory=new Category();
            nowCategory=productService.getCategoryBycategoryId(classification.getCategoryId());
            nowCategoryList.add(nowCategory);
            nowItemList = productService.getAllItembByCategoryId(nowCategory.getCategoryId(),1);
        }

        session.setAttribute("nowItem",item);
        session.setAttribute("nowclassifList",categoryList);
        session.setAttribute("nowcategoryList",nowCategoryList);
        session.setAttribute("nowItemList",nowItemList);
        request.getRequestDispatcher(VIEW_PRODUCT).forward(request,response);
    }
}
