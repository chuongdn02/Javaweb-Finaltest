/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handling_350_114;

import model_114.Detail;
import model_114.WLine;
import model_114.product;
import model_114.user;
import model_114.admin;
import connect_333.connection;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macpro
 */
public class Handling {

    public static List<product> GetAllproduct() {
        List<product> PrData = new ArrayList<product>();
        Connection conn = connection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from product");
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                product PrD = new product();

                PrD.setid(result.getInt("idProduct"));
                PrD.setname(result.getString("name"));
                PrD.setprice(result.getString("price"));
                PrD.setdes(result.getString("des"));
                PrD.settitle(result.getString("title"));
                PrData.add(PrD);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PrData;
    }

    public static WLine GetWLine(int id) {
        WLine PrD = new WLine();
        Connection conn = connection.getJDBCConnection();

        try {

            PreparedStatement ps = conn.prepareStatement("select * from WLine where idWLine = " + id);
            //ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {

                PrD.setIdUser(result.getInt("id"));
                PrD.setname(result.getString("name"));
                PrD.setprice(result.getString("price"));
                PrD.setdes(result.getString("des"));
                PrD.settitle(result.getString("title"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PrD;
    }

    public List<WLine> GetAllWLine() {
        List<WLine> PrWData = new ArrayList<WLine>();
        Connection conn = connection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from WLine");
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                WLine PrD1 = new WLine();

                PrD1.setid(result.getInt("idWLine"));
                PrD1.setIdUser(result.getInt("id"));
                PrD1.setname(result.getString("name"));
                PrD1.setprice(result.getString("price"));
                PrD1.setdes(result.getString("des"));
                PrD1.settitle(result.getString("title"));
                PrWData.add(PrD1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PrWData;
    }

    public List<admin> GetAlladmin() {
        List<admin> accounts = new ArrayList<admin>();
        Connection conn = connection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from admin");
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                admin ADacc = new admin();

                ADacc.setid(result.getString("id"));
                ADacc.setpass(result.getString("pass"));

                accounts.add(ADacc);
            }
            return accounts;
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<user> GetAlluser() {
        List<user> accounts = new ArrayList<user>();
        Connection conn = connection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from user");
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                user Uacc = new user();

                Uacc.setname(result.getString("name"));
                Uacc.setphone(result.getString("phone"));
                Uacc.setpass(result.getString("pass"));
                Uacc.setsex(result.getString("sex"));
                Uacc.setadd(result.getString("adr"));
                accounts.add(Uacc);
            }
            return accounts;
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public admin Signinadmin(String id) {
        Connection conn = connection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from admin");
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                if (result.getString("id").equals(id)) {
                    admin adacc = new admin();
                    System.out.println(id);
                    adacc.setid(result.getString("id"));
                    adacc.setpass(result.getString("pass"));

                    return adacc;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public user SigninUSER(String phone) {
        Connection conn = connection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from user");
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                if (result.getString("phone").equals(phone)) {
                    user uacc = new user();
                    System.out.println(phone);
                    uacc.setphone(result.getString("phone"));
                    uacc.setpass(result.getString("pass"));

                    return uacc;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void SignupAccount(user account) {
        Connection conn = connection.getJDBCConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("insert into user(phone,pass,name,adr,sex) value (?,?,?,?,?)");
            ps.setString(1, account.getphone());
            ps.setString(2, account.getpass());
            ps.setString(3, account.getname());
            ps.setString(4, account.getadd());
            ps.setString(5, account.getsex());
            int result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AddNewProductData(WLine PrD) {
        Connection conn = connection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("insert into product(id,name,price,title,des) value (?,?,?,?,?)");
            ps.setInt(1, PrD.getIdUser());
            ps.setString(2, PrD.getname());
            ps.setString(3, PrD.getprice());
            ps.setString(4, PrD.gettitle());
            ps.setString(5, PrD.getdes());

            int result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 public void AddNewProductWLine(product PrD) {
        Connection conn = connection.getJDBCConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("insert into WLine(id,name,price,title,des) value (?,?,?,?,?)");
            ps.setInt(1, PrD.getIdUser());
            ps.setString(2, PrD.getname());
            ps.setString(3, PrD.getprice());
            ps.setString(4, PrD.gettitle());
            ps.setString(5, PrD.getdes());

            int result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeleteWLine(int id) {
        Connection conn = connection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("delete from WLine where idWLine = ?");
            ps.setInt(1, id);

            int result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Delpr(int id) {
        Connection conn = connection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("delete from product where idProduct = ?");
            ps.setInt(1, id);

            int result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ShowtData(product PrD) {
        Connection conn = connection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from product, user");
            ResultSet result = ps.executeQuery();
            product PrD3 = new product();
            user u = new user();

            PrD3.setid(result.getInt("id"));
            PrD3.setname(result.getString("name"));
            PrD3.setprice(result.getString("price"));
            PrD3.setdes(result.getString("des"));
            PrD3.settitle(result.getString("title"));
            u.setname(result.getString("name"));
            u.setphone(result.getString("phone"));
            u.setsex(result.getString("sex"));
            u.setadd(result.getString("adr"));

        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<product> GetResultSearch(String valueSearch) {
        List<product> PrData = new ArrayList<>();
        Connection conn = connection.getJDBCConnection();

        try {
            Statement ps = null;
            String pst = "select * from product where title like '%" + valueSearch + "%'";
            ps = conn.createStatement();
            ResultSet result = ps.executeQuery(pst);
            while (result.next()) {
                product PrD = new product();
                PrD.setid(result.getInt("id"));
                PrD.setname(result.getString("name"));
                PrD.setprice(result.getString("price"));
                PrD.settitle(result.getString("title"));
                PrD.setdes(result.getString("des"));

                PrData.add(PrD);
            }
            return PrData;
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Detail getInfo(int id) {
        Detail de = new Detail();
        Connection conn = connection.getJDBCConnection();
        try {
            //String sql = "select title, price, des, user.name, phone, adr from user join product on user.id = product.id where product.idProduct = 1";
            PreparedStatement preparedStatement = conn.prepareStatement("select title, price, des, user.name, phone, adr from user join product on user.id = product.id where product.idProduct = " + id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                de.setTitle(resultSet.getString("title"));
                de.setPrice(resultSet.getString("price"));
                de.setDes(resultSet.getString("des"));
                de.setName(resultSet.getString("user.name"));
                de.setPhone(resultSet.getString("phone"));
                de.setAddr(resultSet.getString("adr"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return de;
    }

    public static void SelectID(int id) {
        Connection conn = connection.getJDBCConnection();
        try {
            //String sql = "insert into selectID values(?)";

            PreparedStatement preparedStatement = conn.prepareStatement("insert into selectID(id) value(?)");
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getID() {
        Connection conn = connection.getJDBCConnection();
        int id = 0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select id from selectID");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public static void RemoveID(int id) {
        Connection conn = connection.getJDBCConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("delete from selectID where id =?");
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void SelectPhone(String phone) {
        Connection conn = connection.getJDBCConnection();
        try {
            //String sql = "insert into selectID values(?)";

            PreparedStatement preparedStatement = conn.prepareStatement("insert into selectID(phoneNumber) values(?)");
            preparedStatement.setString(1, phone);
            int result = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getPhone() {
        Connection conn = connection.getJDBCConnection();
        String phone = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select phoneNumber from selectID");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                phone = resultSet.getString("phoneNumber");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phone;
    }

    public static int getIDPhone() {
        Connection conn = connection.getJDBCConnection();
        int id = 0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select id from user where phone = ?");
            preparedStatement.setString(1, Handling.getPhone());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public static void RemovePhone() {
        Connection conn = connection.getJDBCConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("delete from selectID");

            int result = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Handling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        WLine p = GetWLine(2);
        System.out.println(p.getIdUser());
    }
}
