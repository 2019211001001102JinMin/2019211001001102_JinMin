package com.JinMin.dao;

import com.JinMin.model.Product;
import com.JinMin.model.User;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    public int save(Product product ,InputStream inputStream,Connection con)throws SQLException {

        int n = 0;
        System.out.println("IN SAVE");
        String sql = "insert into Product(ProductName,ProductDescription,Picture,Price,CategoryId) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        System.out.println(product.getProductName());
        pt.setString(1, product.getProductName());
        System.out.println(product.getProductDescription());
        pt.setString(2, product.getProductDescription());
        if(inputStream!=null) {
            //for sql server
            System.out.println(inputStream);
            pt.setBinaryStream(3, inputStream);
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        System.out.println(product.getPrice());
        pt.setDouble(4, product.getPrice());
        System.out.println(product.getCategoryId());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        System.out.println(n);
        if (n > 0) {
            return n;
        }
        return 0;
    }
    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        int n = 0;
        String sql = "delete from Product where ProductId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, productId);
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }

        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        int n = 0;
        String sql = "update Product set ProductName=?,ProductDescription=?,Picture=?,Price=?,CategoryId=? where ProductId=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, instance.getProductName());
        pt.setString(2, instance.getProductDescription());
        if(instance.getPicture()!=null) {
            pt.setBinaryStream(3, instance.getPicture());
        }
        pt.setDouble(4, instance.getPrice());
        pt.setInt(5, instance.getCategoryId());
        pt.setInt(6,instance.getProductId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {

        Product product=new Product();
        String sql = "select * from Product where productId=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, productId);
        Statement createDbStatement = con.createStatement();
        ResultSet rs = createDbStatement.executeQuery(sql);
        while (rs.next()) {

            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName")) ;
            product.setProductDescription(rs.getString("ProductDescription")) ;
            product.setPrice(rs.getDouble("Price") ) ;
            product.setCategoryId(rs.getInt("CategoryId") ) ;
            product.setPicture(rs.getBinaryStream("Picture") ) ;
        }

        return product;

    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {

        String sql="select * from  Product where categoryId = ? ";
        PreparedStatement st=con.prepareStatement(sql) ;
        st.setInt(1, categoryId);
        ResultSet rs=st.executeQuery() ;
        Product product=null;
        List<Product> productList=new ArrayList<Product>();
        while(rs.next() ){

            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName")) ;
            product.setProductDescription(rs.getString("ProductDescription")) ;
            product.setPrice(rs.getDouble("Price") ) ;
            product.setCategoryId(rs.getInt("CategoryId") ) ;
            productList.add(product);
        }

        return productList;

    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        String sql="select * from  Product where price< ? and price >? ";
        PreparedStatement st=con.prepareStatement(sql) ;
        st.setDouble(1, minPrice);
        st.setDouble(2, minPrice);
        ResultSet rs=st.executeQuery() ;
        Product product=null;
        List<Product> productList=new ArrayList<Product>();
        while(rs.next() ){

            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName")) ;
            product.setProductDescription(rs.getString("ProductDescription")) ;
            product.setPrice(rs.getDouble("Price") ) ;
            product.setCategoryId(rs.getInt("CategoryId") ) ;
            productList.add(product);
        }

        return productList;

    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {

        String sql="select * from  Product";
        PreparedStatement st=con.prepareStatement(sql) ;
        ResultSet rs=st.executeQuery() ;
        Product product=null;
        List<Product> productList=new ArrayList<Product>();
        while(rs.next() ){

            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName")) ;
            product.setProductDescription(rs.getString("ProductDescription")) ;
            product.setPrice(rs.getDouble("Price") ) ;
            product.setCategoryId(rs.getInt("CategoryId") ) ;
            productList.add(product);
        }
        System.out.println("successful");

        return productList;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        String sql="select * from  Product where productName = ? ";
        PreparedStatement st=con.prepareStatement(sql) ;
        st.setString(1, productName) ;
        ResultSet rs=st.executeQuery() ;
        Product product=null;
        List<Product> productList=new ArrayList<Product>();
        while(rs.next() ){

            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName")) ;
            product.setProductDescription(rs.getString("ProductDescription")) ;
            product.setPrice(rs.getDouble("Price") ) ;
            product.setCategoryId(rs.getInt("CategoryId") ) ;
            productList.add(product);
        }

        return productList;

    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }
    public static byte[] getPictureById(Integer productId, Connection con) throws SQLException {
        byte[] imBytes=null;
        String sql="select picture from product where productId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery() ;
        while (rs.next()){
            Blob blob=rs.getBlob("picture");
            imBytes =blob.getBytes(1,(int)blob.length());
        }
        return imBytes ;
    }


}
