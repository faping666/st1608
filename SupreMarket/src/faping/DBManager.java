package faping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;


public class DBManager {
	/**
	 * 余额
	 */
	static String VBalance;
	/**
	 * 积分
	 */
	static String ConsumeScore;
	/**
	 * 会员姓名
	 */
	static String VName;
	/**
	 * 商品条码
	 */
	static String GId;

	static String pwd ;
	static String job ;

	static String url = "jdbc:mysql://localhost:3306/demodb?useUnicode=true&amp;characterEncoding=utf8";
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	public static Connection getconn (){	
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, "root", "root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭
	 */
	public static void close() {
		try {
			ps.close();
			conn.close();
			if (rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 登录
	 * @param uname 登录框提取的账号信息
	 * @return 返回查询的密码和权限信息
	 */

	public static Vector<String> Login(String uid ) {
		Vector<String> vector = new Vector<String>();
		try {
			ps = getconn().prepareStatement("select UPassword,URole,UName from SuperMarketUser where UId=? ");
			ps.setString(1, uid);
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				pwd = rs.getString(1);
				job=rs.getString(2);
				vector.add(pwd);
				vector.add(job);
				vector.add(rs.getString(3).toString());
				return vector;
			} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return null;

	}



	/**
	 * 查询会员信息
	 * @param Vid 会员编号
	 * @return 返回一个集合 包括姓名，积分和余额
	 */

	public static Vector selectVIP(String Vid) {
		Vector vector = new Vector();
		try {
			ps = getconn().prepareStatement("select VName,ConsumeScore,VBalance,ConsumeRate,VId from ShopVip where VId=? ");
			ps.setString(1,Vid);
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				VName = rs.getString(1);
				ConsumeScore = rs.getString(2);
				VBalance = rs.getString(3);
				vector.add(VName);
				vector.add(ConsumeScore);
				vector.add(VBalance);
				vector.add(rs.getDouble(4));
				vector.add(rs.getString(5));
				return vector;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return null;
	}
	/**
	 * 添加VIP信息
	 */
	public static void insertVIP(String id,String vname,String tel,double score,String birth) {
		boolean ishave = false;
		try {
			ps = getconn().prepareStatement("select VId from ShopVip where VId= ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				ishave = true;
			}
			if (ishave) {
				JOptionPane.showMessageDialog(null, "卡号重复！");
			} else {	
				ps = getconn().prepareStatement("insert into ShopVip values(?,?,?,0,0,0,?,?,0)");
				ps.setString(1, id);
				ps.setString(2, vname);
				ps.setString(3, tel);
				ps.setDouble(4, score);
				ps.setString(5, birth);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}


	/**
	 * 删除VIP信息
	 */
	public static void delVIP(String id) {
		try {
			ps = getconn().prepareStatement("delete ShopVip where VId=?");
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "VIP有消费或充值记录，不允许删除！");
		}
		finally{
			DBManager.close();
		}
	}
	/**
	 * 修改VIP信息
	 */
	public static void updateVIP(String name,String tel,String birth,double score,String id) {
		try {
			ps = getconn().prepareStatement("update ShopVip set VName=?,VPhone=?,VBirthday=? ,ConsumeRate=? where VId=?");
			ps.setString(1, name);
			ps.setString(2, tel);
			ps.setString(3, birth);
			ps.setDouble(4, score);
			ps.setString(5, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}

	/**
	 * 会员充值
	 */
	public static void vbalance(double money,String VID) {
		try {
			ps = getconn().prepareStatement("update ShopVip set VBalance =VBalance+? where VId = ?");
			ps.setDouble(1,money);
			ps.setString(2,VID);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}

	/**
	 * 模糊查询VIP信息
	 */
	public static Vector<Vector<String>> selectvip(String inif) {
		Vector<Vector<String>> v = new Vector<Vector<String>>();
		try {
			ps = getconn().prepareStatement("select * from ShopVip");
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				if (rs.getString(1).contains(inif)||rs.getString(2).contains(inif)||rs.getString(3).contains(inif)) {
					Vector<String> vector = new Vector<String>();
					vector.add(rs.getString(1));
					vector.add(rs.getString(2));
					vector.add(rs.getString(8));
					vector.add(rs.getString(3));
					vector.add(rs.getString(4));
					vector.add(rs.getString(5));
					vector.add(rs.getString(6));
					vector.add(rs.getString(7));
					vector.add(rs.getString(9));
					v.add(vector);	
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;

	}

	/**
	 * 会员充值记录添加
	 */
	public static void topUpVIP(String vid , String vtime ,Double vmoney,String uid) {
		try {
			ps = getconn().prepareStatement("insert into VipSaveMoney(vid,vtime,vmoney,uid) values(?,?,?,?)");
			ps.setString(1, vid);
			ps.setString(2, vtime);
			ps.setDouble(3, vmoney);
			ps.setString(4, uid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}

	/**
	 * 查询全部VIP信息
	 */
	public static Vector<Vector<String>> selectallvip() {
		Vector<Vector<String>> v = new Vector<Vector<String>>();
		try {
			ps = getconn().prepareStatement("select * from ShopVip");
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				Vector<String> vector = new Vector<String>();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(8));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				vector.add(rs.getString(5));
				vector.add(rs.getString(6));
				vector.add(rs.getString(7));
				vector.add(rs.getString(9));
				v.add(vector);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;
	}
	/**
	 * 商品管理-查询类别
	 */
	public static int selectgoodsclass(String gclass) {

		try {
			ps = getconn().prepareStatement("select CId from GoodsClass where CName = ?");
			ps.setString(1, gclass);
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				int gclass1 = rs.getInt(1);
				return gclass1;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return -1;
	}

	/**
	 * 商品管理-查询类别
	 * 返回类别名称
	 */
	public static String selectcname(int gclass) {
		try {
			ps = getconn().prepareStatement("select CName from GoodsClass where CId = ?");
			ps.setInt(1, gclass);
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				String gclass1 = rs.getString(1);
				return gclass1;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return null;
	}

	/**
	 * 商品管理-查询单位
	 * 返回单位ID
	 */
	public static int selectgoodsunit(String gunit) {

		try {
			ps = getconn().prepareStatement("select GUId from GoodsUnit where GUName = ?");
			ps.setString(1, gunit);
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				int gunit1 = rs.getInt(1);
				return gunit1;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return -1;
	}

	/**
	 * 商品管理-查询单位
	 * 返回单位名字
	 */
	public static String selectgoodsuname(int gunit) {
		try {
			ps = getconn().prepareStatement("select GUName from GoodsUnit where GUId = ?");
			ps.setInt(1, gunit);
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				String gunit1 = rs.getString(1);
				return gunit1;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return null;
	}


	/**
	 * 进货管理-查询商品信息
	 */
	public static Vector<Object> selectgood(String gid) {
		try {
			ps = getconn().prepareStatement("select * from Goods where GId = ?");
			ps.setString(1, gid);
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				Vector<Object> vector = new Vector<Object>();
				vector.add(rs.getInt(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				vector.add(rs.getInt(5));
				vector.add(rs.getInt(6));
				vector.add(rs.getDouble(7));
				vector.add(rs.getDouble(8));
				vector.add(rs.getInt(9));
				return vector;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return null;
	}
	/**
	 * 进货管理 添加商品信息
	 */

	public static void insertgoods(String gid,int gclass,String name,String gspec,int gunit,int numbuter,double gprice,double gvprice,int cnumputer) {
		try {
			ps = getconn().prepareStatement("insert into Goods values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, gid);
			ps.setInt(2, gclass);
			ps.setString(3, name);
			ps.setString(4, gspec);
			ps.setInt(5, gunit);
			ps.setInt(6, numbuter);
			ps.setDouble(7, gprice);
			ps.setDouble(8, gvprice);
			ps.setInt(9, cnumputer);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}
	/**
	 * 商品管理 修改商品信息
	 */
	public static void updategoods(String name,int gclass,int gunit,String gspec,int numbuter,double gprice,double gvprice,String gid) {
		try {
			ps = getconn().prepareStatement("update Goods set GName = ? ,CId = ? ,GUId = ? ,GSpec = ? ,GMinNumber = ? ,SalePrice = ? ,VipPrice = ?  where GId = ? ");
			ps.setString(1, name);
			ps.setInt(2, gclass);
			ps.setInt(3, gunit);
			ps.setString(4, gspec);
			ps.setInt(5, numbuter);
			ps.setDouble(6, gprice);
			ps.setDouble(7, gvprice);
			ps.setString(8, gid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}

	/**
	 * 商品管理查询商品信息
	 * @return 返回查询的信息
	 */
	public static Vector selectgood() {
		Vector v = new Vector();
		try {
			ps = getconn().prepareStatement("select GId,GName,GoodsClass.CName,GSpec,GoodsUnit.GUName,GMinNumber,SalePrice,VipPrice,GAmount from Goods,GoodsUnit,GoodsClass where GoodsUnit.GUId=goods.guid and GoodsClass.CId=Goods.cid ");
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				Vector vector = new Vector();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				vector.add(rs.getString(5));
				vector.add(rs.getInt(6));
				vector.add(rs.getDouble(7));
				vector.add(rs.getDouble(8));
				vector.add(rs.getInt(9));
				v.add(vector);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;
	}

	/**
	 * 商品管理删除商品信息
	 */
	public static void goodsdel(String gid) {
		try {
			ps = getconn().prepareStatement("delete Goods where GId = ?");
			ps.setString(1, gid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "商品信息已使用,不允许删除！");
		}
		finally{
			DBManager.close();
		}
	}



	/**
	 * 商品管理模糊查询商品信息
	 * @return 返回查询的信息
	 */
	public static Vector selectgoods(String inif) {
		Vector v = new Vector();
		try {
			ps = getconn().prepareStatement("select GId,GName,GoodsClass.CName,GSpec,GoodsUnit.GUName,GMinNumber,SalePrice,VipPrice,GAmount from Goods,GoodsUnit,GoodsClass where GoodsUnit.GUId=goods.guid and GoodsClass.CId=Goods.cid ");
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				if (rs.getString(1).contains(inif)||rs.getString(2).contains(inif)||rs.getString(3).contains(inif)||rs.getString(4).contains(inif)||rs.getString(5).contains(inif)||rs.getString(6).contains(inif)||rs.getString(7).contains(inif)||rs.getString(8).contains(inif)||rs.getString(9).contains(inif)){
					Vector vector = new Vector();
					vector.add(rs.getString(1));
					vector.add(rs.getString(2));
					vector.add(rs.getString(3));
					vector.add(rs.getString(4));
					vector.add(rs.getString(5));
					vector.add(rs.getInt(6));
					vector.add(rs.getDouble(7));
					vector.add(rs.getDouble(8));
					vector.add(rs.getInt(9));
					v.add(vector);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;
	}



	/**
	 * 收银查询商品信息
	 * @return 返回查询的信息
	 */
	public static Vector selectware(String GId) {
		try {
			ps = getconn().prepareStatement("select GId,GName,GSpec,GoodsUnit.GUName,GAmount,VipPrice,SalePrice from Goods,GoodsUnit,GoodsClass where goods.GId=? and GoodsUnit.GUId=goods.guid and GoodsClass.CId=Goods.cid ");
			ps.setString(1, GId);
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				Vector vector = new Vector();
				GId =rs.getString(1);
				String GName = rs.getString(2);
				String GSpec = rs.getString(3);
				String GUName = rs.getString(4);
				int GAmount = rs.getInt(5);
				Double VipPrice = rs.getDouble(6);
				Double SalePrice = rs.getDouble(7);
				vector.add(GId);
				vector.add(GName);
				vector.add(GSpec);
				vector.add(GUName);
				vector.add(GAmount);
				vector.add(VipPrice);
				vector.add(SalePrice);
				return vector;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return null;
	}
	
	/**
	 * 收银--添加销售表
	 */
	public static void insertSell(String maxid, int coun , String uid ,String vid) {
		int id = 0 ;
		try {
			ps = getconn().prepareStatement("insert into Sell(SId,STime,SCount,UId,VId) values(?,?,?,?,?)");
			ps.setString(1, maxid);
			ps.setString(2, getDate());
			ps.setInt(3, coun);
			ps.setString(4, uid);
			ps.setString(5, vid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}
	
	/**
	 * 收银 - 添加销售详情
	 */
	public static void insertSellDatal(String maxid, String gid,int coun,double price) {
		
		try {
			ps = getconn().prepareStatement("insert into SellDetail values(?,?,?,?)");
			ps.setString(1, maxid);
			ps.setString(2, gid);
			ps.setInt(3, coun);
			ps.setDouble(4, price);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}
	
	/**
	 * 收银--修改商品库存
	 */
	public static void modifyNO(String id , int numbuter) {
		try {
			ps = getconn().prepareStatement("update Goods set GAmount = GAmount-? where GId = ? ");
			ps.setInt(1, numbuter);
			ps.setString(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}

	/**
	 * 收银--会员消费 修改余额和积分
	 */
	public static void updateVipinfo(double money,double score,String vid) {
		try {
			ps = getconn().prepareStatement("update ShopVip set VBalance = VBalance - ?,ConsumeScore = ConsumeScore+?,ConsumeSum = ConsumeSum+?,ConsumeCount=ConsumeCount+1 where VId = ?");
			ps.setDouble(1, money);
			ps.setDouble(2, money*score);
			ps.setDouble(3, money);
			ps.setString(4, vid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 收银--会员消费 余额不够结账
	 */
	public static void updateVipinfo1(double money,double score,String vid) {
		try {
			ps = getconn().prepareStatement("update ShopVip set VBalance = 0,ConsumeScore = ConsumeScore+? ,ConsumeSum = ConsumeSum+?,ConsumeCount=ConsumeCount+1where VId = ?");
			ps.setDouble(1, money*score);
			ps.setDouble(2, money);
			ps.setString(3, vid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}
	
	/**
	 * 添加单位信息
	 */
	public static void AddUnit(String uname) {
		boolean is = false;
		try {
			ps = getconn().prepareStatement("select GUName from GoodsUnit");
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				if (uname.equals(rs.getString(1))) {
					is = true ;
					JOptionPane.showMessageDialog(null, "单位已存在！");
					break;
				}
			}
			if (!is) {
				ps = conn.prepareStatement("insert into GoodsUnit values(?)");
				ps.setString(1, uname);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close();
		}
	}

	/**
	 * 查询全部计量单位
	 * @return 
	 */
	public static Vector selectUnit() {
		Vector v = new Vector();
		String sql = "select *  from GoodsUnit";
		try {
			ps = getconn().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs!=null&&rs.next()) {
				Vector vector = new Vector();
				String id = rs.getString(1);
				String name = rs.getString(2);
				vector.add(id);
				vector.add(name);
				v.add(vector);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;
	}
	/**
	 * 进货管理 添加商品
	 */


	/**
	 * 进货管理 添加库存
	 */
	public static void updatecnumbuter(String gid,int cnumbuter) {
		try {
			ps = getconn().prepareStatement("update Goods set GAmount = GAmount + ? where GId = ?");
			ps.setInt(1, cnumbuter);
			ps.setString(2, gid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}

	/**
	 * 商品管理计量单位下拉菜单
	 * @return 
	 */
	public static Vector selectgoodu() {
		Vector v = new Vector();
		String sql = "select *  from GoodsUnit";
		try {
			ps = getconn().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs!=null&&rs.next()) {
				String name = rs.getString(2);
				v.add(name);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;
	}

	/**
	 * 商品管理供应商下拉菜单
	 * @return 
	 */
	public static Vector selectgoodsP() {
		Vector v = new Vector();
		String sql = "select *  from GoodsPrivoder";
		try {
			ps = getconn().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs!=null&&rs.next()) {
				String name = rs.getString(2);
				v.add(name);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;
	}


	/**
	 * 单位信息模糊查询
	 * @return
	 */

	public static Vector selectuni(String inif) {
		Vector v = new Vector();
		try {
			ps = getconn().prepareStatement("select * from GoodsUnit ");
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				if (rs.getString(1).contains(inif)||rs.getString(2).contains(inif)) {
					Vector vector = new Vector();
					vector.add(rs.getString(1));
					vector.add(rs.getString(2));
					v.add(vector);	
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;

	}


	/**
	 * 添加供货信息
	 */
	public static void Addsupply(String gpname,String gptel,String gpadd,String gpuser) {
		try {
			boolean ishave = false;
			ps = getconn().prepareStatement("select GPName from GoodsPrivoder where GPName=?");
			ps.setString(1, gpname);	
			rs = 	ps.executeQuery();
			while (rs.next()&&rs!=null) {
				ishave=true;
			}
			if (!ishave) {
				ps = getconn().prepareStatement("insert into GoodsPrivoder values(?,?,?,?)");
				ps.setString(1, gpname);
				ps.setString(2, gptel);
				ps.setString(3, gpadd);
				ps.setString(4, gpuser);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "添加成功！");
			} else {
				JOptionPane.showMessageDialog(null, "供应商名称重复！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}

	/**
	 * 模糊查询供货信息
	 */
	public static Vector selectsup(String supifin) {
		Vector v = new Vector();
		try {
			ps = getconn().prepareStatement("select * from GoodsPrivoder");
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				if (rs.getString(1).contains(supifin)||rs.getString(2).contains(supifin)||rs.getString(3).contains(supifin)||rs.getString(4).contains(supifin)||rs.getString(5).contains(supifin)) {
					Vector vector = new Vector();
					vector.add(rs.getString(1));
					vector.add(rs.getString(2));
					vector.add(rs.getString(3));
					vector.add(rs.getString(4));
					vector.add(rs.getString(5));
					v.add(vector);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;	
	}

	/**
	 * 修改供货信息
	 */
	public static void updatesup(int gpid,String gpname,String gptel,String gpuser,String gpadd) {
		try {
			ps = getconn().prepareStatement("update GoodsPrivoder set GPName=? ,GPPhone=? ,GPAddress=? ,GPLinkman=? where GPId=? ");
			ps.setString(1, gpname);
			ps.setString(2, gptel);
			ps.setString(3, gpuser);
			ps.setString(4, gpadd);
			ps.setInt(5, gpid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}


	/**
	 * 删除供应商信息
	 */
	public static void delsup(int gpid) {
		try {
			ps = getconn().prepareStatement("delete GoodsPrivoder where GPId=?");
			ps.setInt(1, gpid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "供应商信息已使用，禁止删除！");
		}
		finally{
			DBManager.close();
		}
	}



	/**
	 * 查询全部供货信息
	 */
	public static Vector selectallsup() {
		Vector v = new Vector();
		try {
			ps = getconn().prepareStatement("select * from GoodsPrivoder");
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				Vector vector = new Vector();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				vector.add(rs.getString(5));
				v.add(vector);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;

	}


	/**
	 * 添加类别
	 */
	public static void Addclass(String name){
		boolean is = false;
		try {	
			ps = getconn().prepareStatement("select CName from GoodsClass");
			rs = 	ps.executeQuery();
			while (rs.next()&&rs!=null) {
				if (name.equals(rs.getString(1))) {
					is = true;
					JOptionPane.showMessageDialog(null, "类别已存在！");
					break;
				}
			}
			if (!is) {
				ps = getconn().prepareStatement("insert into GoodsClass values(?)");
				ps.setString(1, name);
				ps.executeUpdate();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}




	/**
	 * 查询全部类别信息
	 * @return 
	 */
	public static Vector selectclass() {
		Vector v = new Vector();
		String sql = "select *  from GoodsClass";
		try {
			ps = getconn().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs!=null&&rs.next()) {
				Vector vector = new Vector();
				String id = rs.getString(1);
				String name = rs.getString(2);
				vector.add(id);
				vector.add(name);
				v.add(vector);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;
	}


	/**
	 * 商品管理类别信息下拉菜单
	 * @return 返回类别名称
	 */
	public static Vector selectgoodclass() {
		Vector v = new Vector();
		String sql = "select *  from GoodsClass";
		try {
			ps = getconn().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs!=null&&rs.next()) {
				Vector vector = new Vector();
				String name = rs.getString(2);
				v.add(name);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;
	}


	/**
	 * 添加管理员信息
	 */
	public static void insertsupp(String id,String pwd,String name,String job) {
		boolean ishave = false;
		try {
			ps = getconn().prepareStatement("select UId from SuperMarketUser where UId= ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				ishave = true;
			}
			if (!ishave) {
				ps = getconn().prepareStatement("insert into SuperMarketUser values(?,?,?,?)");
				ps.setString(1, id);
				ps.setString(2, pwd);
				ps.setString(3, name);
				ps.setString(4, job);
				ps.executeUpdate();
			} else {
				JOptionPane.showMessageDialog(null, "账号重复！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}

	/**
	 * 查询用户管理全部信息
	 */

	public static Vector selectuserall() {
		Vector v = new Vector();
		try {
			ps = getconn().prepareStatement("select * from SuperMarketUser");
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				Vector vector = new Vector();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				v.add(vector);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;
	}

	/**
	 * 删除管理员信息
	 */
	public static void deluser(String id) {
		try {
			ps = getconn().prepareStatement("delete SuperMarketUser where UId=?");
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "该用户有重要操作,禁止删除！");
		}
		finally{
			DBManager.close();
		}
	}

	/**
	 * 修改管理员信息
	 */
	public static void updateuser(String pwd, String name, String job, String id) {
		try {
			ps = getconn().prepareStatement("update SuperMarketUser set UPassword=? ,UName=? ,URole=? where UId=? ");
			ps.setString(1,pwd);
			ps.setString(2, name);
			ps.setString(3, job);
			ps.setString(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}
	/**
	 * 管理员信息模糊查询
	 */
	public static Vector selectuser(String inif) {  
		Vector v = new Vector();
		try {
			ps = getconn().prepareStatement("select * from SuperMarketUser");
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				if (rs.getString(1).contains(inif)||rs.getString(3).contains(inif)) {
					Vector vector = new Vector();
					vector.add(rs.getString(1));
					vector.add(rs.getString(2));
					vector.add(rs.getString(3));
					vector.add(rs.getString(4));
					v.add(vector);	
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;

	}


	/**
	 * 类别信息模糊查询
	 * @return
	 */

	public static Vector selectc(String inif) {
		Vector v = new Vector();
		try {
			ps = getconn().prepareStatement("select * from GoodsClass ");
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				if (rs.getString(1).contains(inif)||rs.getString(2).contains(inif)) {
					Vector vector = new Vector();
					vector.add(rs.getString(1));
					vector.add(rs.getString(2));
					v.add(vector);	
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;

	}



	/**
	 * 删除单位
	 */
	public static void deleteunit(String uname){
		try {
			ps = getconn().prepareStatement("delete GoodsUnit where GUName = ? ");
			ps.setString(1, uname);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "单位已使用，禁止删除！");
		}
		finally{
			DBManager.close();
		}
	}



	/**
	 * 删除种类
	 */
	public static void delete(String gname){
		try {
			ps = getconn().prepareStatement("delete GoodsClass where CName = ? ");
			ps.setString(1, gname);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "种类已使用，禁止删除！");
		}
		finally{
			DBManager.close();
		}
	}
	/**
	 * 修改类别信息
	 */
	public static void updateclass(String gname,int cid) {
		try {
			ps = getconn().prepareStatement("update GoodsClass set CName= ? where CId=?");
			ps.setString(1, gname);
			ps.setInt(2, cid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}


	/**
	 * 修改单位信息
	 */
	public static void updateunit(String gname,int cid) {
		try {
			ps = getconn().prepareStatement("update GoodsUnit set GUName= ? where GUId=?");
			ps.setString(1, gname);
			ps.setInt(2, cid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}
	/**
	 * 进货管理-供应商下拉菜单
	 * 返回ID
	 */
	public static int selectPrivoder(String privoder) {
		int pid = 0 ;
		try {
			ps = getconn().prepareStatement("select * from GoodsPrivoder where GPName = ?");
			ps.setString(1, privoder);
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				pid = rs.getInt(1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return pid;
	}


	/**
	 * 进货管理-添加采购表
	 */
	public static void insetInStore(String wasteid,String gid,int gpid,String datetime,int jnumbuter,double jprice) {
		try {
			ps = getconn().prepareStatement("insert into InStore values(?,?,?,?,?,?)");
			ps.setString(1, wasteid);
			ps.setString(2, gid);
			ps.setInt(3, gpid);
			ps.setString(4, datetime);
			ps.setInt(5, jnumbuter);
			ps.setDouble(6, jprice);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
	}

	/**
	 * 系统管理-会员充值明细全部查询
	 */
	public static Vector selectvip() {
		Vector v = new Vector();
		try {
			ps = getconn().prepareStatement("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;
	}

	/**
	 * 系统管理 - 进货明细条件查询
	 * 返回集合集
	 */
	public static Vector selectjhmx(String btime , String etime) {
		Vector v = new Vector();
		try {
			ps = getconn().prepareStatement("select InStore.InStoreTime,InStore.InStoreId,Goods.GId,GName,GSpec,GUName,CName,InStore.InStoreAmount,InStore.PurchasePrice,GPName from InStore,Goods,GoodsClass,GoodsPrivoder,GoodsUnit where (InStore.GId=Goods.GId) and (Goods.CId=GoodsClass.CId)and(InStore.GPId=GoodsPrivoder.GPId)and(Goods.GUId = GoodsUnit.GUId) and (InStoreTime between ? and  ?)");
			ps.setString(1, btime);
			ps.setString(2, etime);
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				Vector vector = new Vector();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				vector.add(rs.getString(5));
				vector.add(rs.getString(6));
				vector.add(rs.getString(7));
				vector.add(rs.getInt(8));
				vector.add(rs.getDouble(9));
				vector.add((rs.getInt(8))*(rs.getDouble(9)));
				vector.add(rs.getString(10));
				v.add(vector);			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;
	}

	/**
	 * 销售汇总 - 
	 * 全部商品编号查询
	 */
	public static Vector selectGID() {
		Vector vector = new Vector();;
		try {
			ps = getconn().prepareStatement("select distinct GId from SellDetail");
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				vector.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return vector;
	}

	/**
	 * 销售汇总 - 
	 * 全部商品编号- 条件查询
	 */
	public static Vector selectGID(String btime ,String etime) {
		Vector vector = new Vector();

		try {
			ps = getconn().prepareStatement("select distinct GId from SellDetail,Sell where (STime between ? and ?)and (Sell.SId=SellDetail.SId)");
			ps.setString(1, btime);
			ps.setString(2, etime);
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				vector.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return vector;
	}

	/**
	 * 销售汇总 - 条件查询信息
	 * 
	 */
	public static Vector selectXSHZ(String gId ,String btime ,String etime) {
		Vector vector = new Vector();
		int count = 0;
		double price = 0;
		String s1 = null;
		String s2 = null;
		String s3 = null;
		String s4 = null;
		String s5 = null;
		double s7 =0;
		try {
			ps = getconn().prepareStatement("select SellDetail.GId ,Goods.GName ,Goods.GSpec ,GoodsUnit.GUName ,GoodsClass.CName ,SellDetail.SQuantity ,SellDetail.SSalePrice from SellDetail,Goods,GoodsUnit,GoodsClass,Sell where (Goods.GUId=GoodsUnit.GUId)and(Goods.CId=GoodsClass.CId)and(Goods.GId=SellDetail.GId) and (Sell.SId=SellDetail.SId)and SellDetail.GId = ? and (STime between ? and ?)");
			ps.setString(1, gId);
			ps.setString(2, btime);
			ps.setString(3, etime);
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {		
				count = rs.getInt(6)+count;	
				s1 = rs.getString(1);
				s2 = rs.getString(2);
				s3 = rs.getString(3);
				s4 = rs.getString(4);
				s5 = rs.getString(5);
				price =(rs.getInt(6)*rs.getDouble(7))+price;
			}
			vector.add(s1);
			vector.add(s2);
			vector.add(s3);
			vector.add(s4);
			vector.add(s5);
			vector.add(count);
			vector.add(formart(price));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return vector;
	}

	/**
	 * 销售汇总 - 查询全部信息
	 * 
	 */
	public static Vector selectXSHZ(String gId) {
		Vector vector = new Vector();
		int count = 0;
		double price = 0;
		String s1 = null;
		String s2 = null;
		String s3 = null;
		String s4 = null;
		String s5 = null;
		double s7 =0;
		try {
			ps = getconn().prepareStatement("select SellDetail.GId ,Goods.GName ,Goods.GSpec ,GoodsUnit.GUName ,GoodsClass.CName ,SellDetail.SQuantity ,SellDetail.SSalePrice from SellDetail,Goods,GoodsUnit,GoodsClass where (Goods.GUId=GoodsUnit.GUId)and(Goods.CId=GoodsClass.CId)and(Goods.GId=SellDetail.GId)and SellDetail.GId = ?");
			ps.setString(1, gId);
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {		
				count = rs.getInt(6)+count;	
				s1 = rs.getString(1);
				s2 = rs.getString(2);
				s3 = rs.getString(3);
				s4 = rs.getString(4);
				s5 = rs.getString(5);
				price =(rs.getInt(6)*rs.getDouble(7))+price;
			}
			vector.add(s1);
			vector.add(s2);
			vector.add(s3);
			vector.add(s4);
			vector.add(s5);
			vector.add(count);
			vector.add(formart(price));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return vector;
	}

	/**
	 * 系统管理 - 进货明细查询全部
	 * 返回集合集
	 */
	public static Vector selectjhmx() {
		Vector v = new Vector();
		try {
			ps = getconn().prepareStatement("select InStore.InStoreTime,InStore.InStoreId,Goods.GId,GName,GSpec,GUName,CName,InStore.InStoreAmount,InStore.PurchasePrice,GPName from InStore,Goods,GoodsClass,GoodsPrivoder,GoodsUnit where (InStore.GId=Goods.GId) and (Goods.CId=GoodsClass.CId)and(InStore.GPId=GoodsPrivoder.GPId)and(Goods.GUId = GoodsUnit.GUId)");
			rs = ps.executeQuery();
			while (rs.next()&&rs!=null) {
				Vector vector = new Vector();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				vector.add(rs.getString(5));
				vector.add(rs.getString(6));
				vector.add(rs.getString(7));
				vector.add(rs.getInt(8));
				vector.add(rs.getDouble(9));
				vector.add((rs.getInt(8))*(rs.getDouble(9)));
				vector.add(rs.getString(10));
				v.add(vector);			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return v;
	}

	/**
	 * 得到系统时间
	 */
	public static String getDate(){
		Date d = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sd.format(d);
		return date;
	}

	/**
	 * 得到销售表中最大sid流水号
	 * @return
	 */
	public static String getMaxidXS(){
		Date d = new Date();
		String date = "";
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String fdate = sf.format(d);
		String sql = "select top 1 sid from sell where sid like '"+fdate+"%' order by sid desc";
		try {
			ps = getconn().prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs!=null&&rs.next()){
				String id = rs.getString("sid");
				long nid = Long.parseLong(id)+1;
				date = String.valueOf(nid);
			}
			else{
				date = fdate+"00001";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return date;
	}


	/**
	 * 得到进货表中最大sid流水号
	 */
	public static String getMaxid(){
		Date d = new Date();
		String date = "";
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String fdate = sf.format(d);
		String sql = "select top 1 InStoreId from InStore where InStoreId like '"+fdate+"%' order by InStoreId desc";
		try {
			ps = getconn().prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs!=null&&rs.next()){
				String id = rs.getString("InStoreId");
				long nid = Long.parseLong(id)+1;
				date = String.valueOf(nid);
			}
			else{
				date = fdate+"00001";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBManager.close();
		}
		return date;
	}


	/**
	 * 格式化数字
	 */
	
	public static String formart(Double money) {
		DecimalFormat df = new DecimalFormat("0.00");
		String ii = df.format(money);
		return ii;
	}
	

	
	/**
	 * 系统管理-销售明细（查全部）
	 * @return销售明细结果集
	 */
	public static Vector xiaoshoumingxiselect() {
		Vector v=new Vector();
		try {
			ps=getconn().prepareStatement("select Sell.STime,SellDetail.SId ,SellDetail.GId ,Goods.GName,Goods.GSpec,GoodsUnit.GUName,GoodsClass.CName,SellDetail.SQuantity,SellDetail.SSalePrice,Sell.SCountPrice,Sell.VId,SuperMarketUser.UName from Sell,SellDetail,Goods,GoodsUnit,GoodsClass,SuperMarketUser where (Sell.SId=SellDetail.SId)and(Sell.UId=SuperMarketUser.UId)and(SellDetail.GId=Goods.GId)and(Goods.GUId=GoodsUnit.GUId)and(Goods.CId=GoodsClass.CId)");
			rs=ps.executeQuery();
			while (rs!=null&&rs.next()) {
				Vector vector=new Vector();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				vector.add(rs.getString(5));
				vector.add(rs.getString(6));
				vector.add(rs.getString(7));
				vector.add(rs.getInt(8));
				vector.add(rs.getDouble(9));
				vector.add(rs.getInt(8)*rs.getDouble(9));
				vector.add(rs.getString(11));
				vector.add(rs.getString(12));
				v.add(vector);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		finally{
			DBManager.close();
		}
		return v;
	}
	/**
	 * 系统管理-销售明细（模糊查询）
	 * @param btime
	 * @param etime
	 * @return
	 */
	public static Vector xiaoshoumingxiselect(String btime,String etime) {
		Vector v=new Vector();
		try {
			ps=getconn().prepareStatement("select Sell.STime,SellDetail.SId ,SellDetail.GId ,Goods.GName,Goods.GSpec,GoodsUnit.GUName,GoodsClass.CName,SellDetail.SQuantity,SellDetail.SSalePrice,Sell.SCountPrice,Sell.VId,SuperMarketUser.UName from Sell,SellDetail,Goods,GoodsUnit,GoodsClass,SuperMarketUser where (Sell.SId=SellDetail.SId)and(Sell.UId=SuperMarketUser.UId)and(SellDetail.GId=Goods.GId)and(Goods.GUId=GoodsUnit.GUId)and(Goods.CId=GoodsClass.CId)and(STime between ? and ?)");
			ps.setString(1,btime);
			ps.setString(2,etime);
			rs=ps.executeQuery();
			while (rs!=null&&rs.next()) {
				Vector vector=new Vector();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				vector.add(rs.getString(5));
				vector.add(rs.getString(6));
				vector.add(rs.getString(7));
				vector.add(rs.getInt(8));
				vector.add(rs.getDouble(9));
				vector.add(rs.getInt(8)*rs.getDouble(9));
				vector.add(rs.getString(11));
				vector.add(rs.getString(12));
				v.add(vector);
			}


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		finally{
			DBManager.close();
		}
		return v;
	}
	/**
	 * 系统管理-会员充值明细查询
	 * @return
	 */
	public static Vector huiyuanchongzhimingxiselect() {
		Vector v=new Vector();
		try {
			ps=getconn().prepareStatement("select VTime,VipSaveMoney.VId,ShopVip.VName,VMoney,SuperMarketUser.UName from VipSaveMoney,ShopVip,SuperMarketUser where (VipSaveMoney.VId=ShopVip.VId)and(VipSaveMoney.UId=SuperMarketUser.UId)");
			rs=ps.executeQuery();
			while (rs!=null&&rs.next()) {
				Vector vector=new Vector();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getDouble(4));
				vector.add(rs.getString(5));
				v.add(vector);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		finally{
			DBManager.close();
		}
		return v;
	}
	/**
	 * 系统管理-会员充值管理（模糊查询）
	 * @param btime
	 * @param etime
	 * @return
	 */
	public static Vector huiyuanchongzhimingxiselect(String btime,String etime) {
		Vector v=new Vector();
		try {
			ps=getconn().prepareStatement("select VTime,VipSaveMoney.VId,ShopVip.VName,VMoney,SuperMarketUser.UName from VipSaveMoney,ShopVip,SuperMarketUser where (VipSaveMoney.VId=ShopVip.VId)and(VipSaveMoney.UId=SuperMarketUser.UId)and(VTime between ? and ?)");
			ps.setString(1,btime);
			ps.setString(2,etime);
			rs=ps.executeQuery();
			while (rs!=null&&rs.next()) {
				Vector vector=new Vector();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getDouble(4));
				vector.add(rs.getString(5));
				v.add(vector);
			}


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		finally{
			DBManager.close();
		}
		return v;
	}
	/**
	 * 系统管理-进货汇总  条件查询
	 * @return
	 */
	public static Vector jinhuohuizongselect(String btime ,String etime) {
		Vector v=new Vector();
		try {
			ps=getconn().prepareStatement("select InStore.GId,Goods.GName,Goods.GSpec,GoodsUnit.GUName,GoodsClass.CName,InStore.InStoreAmount,InStore.PurchasePrice from InStore,Goods,GoodsUnit,GoodsClass where (Goods.GId = InStore.GId) and (Goods.CId = GoodsClass.CId) and (Goods.GUId=GoodsUnit.GUId)and(InStoreTime between ? and ?)");
			ps.setString(1, btime);
			ps.setString(2, etime);
			rs=ps.executeQuery();
			while (rs!=null&&rs.next()) {
				Vector vector=new Vector();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				vector.add(rs.getString(5));
				vector.add(rs.getInt(6));
				vector.add(rs.getInt(6)*rs.getDouble(7));
				v.add(vector);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		finally{
			DBManager.close();
		}
		return v;
	}

	/**
	 * 系统管理-进货汇总 查询全部
	 * @return
	 */
	public static Vector jinhuohuizongselect() {
		Vector v=new Vector();
		try {
			ps=getconn().prepareStatement("select InStore.GId,Goods.GName,Goods.GSpec,GoodsUnit.GUName,GoodsClass.CName,InStore.InStoreAmount,InStore.PurchasePrice from InStore,Goods,GoodsUnit,GoodsClass where (Goods.GId = InStore.GId) and (Goods.CId = GoodsClass.CId) and (Goods.GUId=GoodsUnit.GUId)");
			rs=ps.executeQuery();
			while (rs!=null&&rs.next()) {
				Vector vector=new Vector();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				vector.add(rs.getString(5));
				vector.add(rs.getInt(6));
				vector.add(rs.getInt(6)*rs.getDouble(7));
				v.add(vector);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		finally{
			DBManager.close();
		}
		return v;
	}
	
	/**
	 * 会员积分兑换
	 * @return 
	 */
	public static void updatescore(String vid ,int score) {
		try {
			ps = getconn().prepareStatement("update ShopVip set ConsumeScore = ConsumeScore-? where VId = ?");
			ps .setInt(1, score);
			ps.setString(2, vid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
