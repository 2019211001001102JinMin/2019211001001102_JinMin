package com.JinMin.dao;

import com.JinMin.model.User;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        try {
            String sql = "insert into usertable(username,password,email,gender,birthdate) values (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            Statement createDbStatement = con.createStatement();
            st.setString(1,user.getUsername());
            st.setString(2,user.getPassword() );
            st.setString(3,user.getEmail() );
            st.setString(4,user.getGender() ) ;
            st.setString(5, String.valueOf(new java.sql.Date(user.getBirthdate().getTime())));
            int i=st.executeUpdate() ;
            if(i>0){
                return true;
            }
            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        try {
            String sql = "delete from usertable where id=?";
            PreparedStatement st= con.prepareStatement(sql);
            st.setInt(1,user.getId() );
            int i= st.executeUpdate();
            if(i>0){
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        try{
            String sql="update usertable set username=?,password=?,email=?,gender=?,birthdate=? where id=?";
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1,user.getUsername() );
            st.setString(2,user.getPassword() ) ;
            st.setString(3,user.getEmail() );
            st.setString(4, user.getGender());
            st.setString(5, String.valueOf(new java.sql.Date(user.getBirthdate().getTime())));
            st.setInt(6,user.getId());
            int i= st.executeUpdate();
            if(i>0){
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        try{
            String sql="select*from usertable where id=?";
            PreparedStatement st=con.prepareStatement(sql) ;
            st.setInt(1,id);
            Statement createDbStatement=con.createStatement() ;
            ResultSet rs = createDbStatement.executeQuery(sql);
            User user=null;
            if(rs.next() ){

                user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username")) ;
                user.setPassword(rs.getString("password")) ;
                user.setEmail(rs.getString("email") ) ;
                user.setGender(rs.getString("gender")) ;
                user.setBirthdate(rs.getDate("birthdate") ) ;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {

        String sql="select id,username,password,email,gender,birthdate from  Usertable where username = ? and password = ?";
        PreparedStatement st=con.prepareStatement(sql) ;
        st.setString(1,username);
        st.setString(2,password) ;
        ResultSet rs=st.executeQuery() ;
        User user=null;
        if(rs.next() ){

            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username")) ;
            user.setPassword(rs.getString("password")) ;
            user.setEmail(rs.getString("email") ) ;
            user.setGender(rs.getString("gender")) ;
            user.setBirthdate(rs.getDate("birthdate") ) ;
        }

        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {

        String sql="select id,username,password,email,gender,birthdate from  Usertable where username = ? ";
        PreparedStatement st=con.prepareStatement(sql) ;
        st.setString(1,username);
        ResultSet rs=st.executeQuery() ;
        User user=null;
        if(rs.next() ){

            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username")) ;
            user.setPassword(rs.getString("password")) ;
            user.setEmail(rs.getString("email") ) ;
            user.setGender(rs.getString("gender")) ;
            user.setBirthdate(rs.getDate("birthdate") ) ;
        }

        return (List<User>) user;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="select id,username,password,email,gender,birthdate from  Usertable where  password = ?";
        PreparedStatement st=con.prepareStatement(sql) ;

        st.setString(1,password) ;
        ResultSet rs=st.executeQuery() ;
        User user=null;
        if(rs.next() ){

            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username")) ;
            user.setPassword(rs.getString("password")) ;
            user.setEmail(rs.getString("email") ) ;
            user.setGender(rs.getString("gender")) ;
            user.setBirthdate(rs.getDate("birthdate") ) ;
        }

        return (List<User>) user;

    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {

        String sql="select id,username,password,email,gender,birthdate from  Usertable where email = ?";
        PreparedStatement st=con.prepareStatement(sql) ;
        st.setString(1,email);

        ResultSet rs=st.executeQuery() ;
        User user=null;
        if(rs.next() ){

            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username")) ;
            user.setPassword(rs.getString("password")) ;
            user.setEmail(rs.getString("email") ) ;
            user.setGender(rs.getString("gender")) ;
            user.setBirthdate(rs.getDate("birthdate") ) ;
        }

        return (List<User>) user;

    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {

        String sql="select id,username,password,email,gender,birthdate from  Usertable where gender = ?";
        PreparedStatement st=con.prepareStatement(sql) ;
        st.setString(1,gender);

        ResultSet rs=st.executeQuery() ;
        User user=null;
        if(rs.next() ){

            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username")) ;
            user.setPassword(rs.getString("password")) ;
            user.setEmail(rs.getString("email") ) ;
            user.setGender(rs.getString("gender")) ;
            user.setBirthdate(rs.getDate("birthdate") ) ;
        }

        return (List<User>) user;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthdate) throws SQLException {

        String sql="select id,username,password,email,gender,birthdate from  Usertable where birthdate = ?";
        PreparedStatement st=con.prepareStatement(sql) ;
        st.setString(1, String.valueOf(birthdate));

        ResultSet rs=st.executeQuery() ;
        User user=null;
        if(rs.next() ){

            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username")) ;
            user.setPassword(rs.getString("password")) ;
            user.setEmail(rs.getString("email") ) ;
            user.setGender(rs.getString("gender")) ;
            user.setBirthdate(rs.getDate("birthdate") ) ;
        }

        return (List<User>) user;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {

        String sql="select id,username,password,email,gender,birthdate from  Usertable ";
        PreparedStatement st=con.prepareStatement(sql) ;
        ResultSet rs=st.executeQuery() ;
        User user=null;
        if(rs.next() ){

            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username")) ;
            user.setPassword(rs.getString("password")) ;
            user.setEmail(rs.getString("email") ) ;
            user.setGender(rs.getString("gender")) ;
            user.setBirthdate(rs.getDate("birthdate") ) ;
        }

        return (List<User>) user;
    }
}
