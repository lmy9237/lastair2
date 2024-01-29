package myDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import myVo.RepresentRoomListVo;
import myVo.RoomCategoryVo;

public class Main2Dao {
   
   // 카테고리 메서?��
   public static ArrayList<RoomCategoryVo> getCateAll(){
      ArrayList<RoomCategoryVo> list1 = new ArrayList<RoomCategoryVo>();// 객체 ?��?��
      Connection conn = DBConnection.getConnection();
      
      String sql = "SELECT room_category_idx,category_name,category_icon" + 
            " FROM room_category" + 
            " ORDER BY room_category_idx asc";
      try {
         PreparedStatement pstmt = conn.prepareStatement(sql); // sql?��?��
         ResultSet rs =pstmt.executeQuery();
         while(rs.next()) {
            int roomCategoryIdx = rs.getInt("room_category_idx");
            String categoryName = rs.getString("category_name");
            String categoryIcon = rs.getString("category_icon");
            RoomCategoryVo vo = new RoomCategoryVo(roomCategoryIdx, categoryName, categoryIcon);
            list1.add(vo);
         //   System.out.println(vo.toString());
         }
         rs.close();
         pstmt.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
      return list1;
   }
   
   // 카테고리별로 ?��?��불러?���?
   public static ArrayList<RepresentRoomListVo> getRoom(int cateIdx){
      ArrayList<RepresentRoomListVo> list2 = new ArrayList<RepresentRoomListVo>(); //arraylist객체?��?��
      Connection conn = DBConnection.getConnection();
      
      /*
      String sql ="SELECT room_idx,room_name, room_score,room_price "  
            + " FROM airbnb_room " 
            + " WHERE room_category_idx = ?";
      */
      String sql= " SELECT i.img1, r.room_name, r.room_score,r.room_price, r.room_idx, r.longitude, r.latitude"  
            + " FROM airbnb_room r, room_image i"  
            + " WHERE r.room_category_idx = ? AND i.room_idx = r.room_idx";
      try {
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, cateIdx);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
            String roomImg1 = rs.getString("img1");
            int roomIdx = rs.getInt("room_idx");
            String roomName = rs.getString("room_name");
            double roomScore = rs.getDouble("room_score");
            int roomPrice = rs.getInt("room_price");
            double latitude = rs.getDouble("latitude");
            double longitude = rs.getDouble("longitude");
            list2.add(new RepresentRoomListVo(roomImg1, roomName, roomScore, roomPrice, latitude, longitude, roomIdx));
         }
         rs.close();
         pstmt.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
      return list2;
   }
   
   // 거리 구하�?
   public double checkDistance(double currentLatitude , double currentLongitude , double roomLatitude, double roomLongitude) {
      double Abstractlongitude = currentLongitude - roomLongitude;
      double distance = (Math.sin(3.14*(currentLatitude)) * Math.sin(3.14*(roomLatitude)))
            + (Math.cos(3.14*(currentLongitude)) * Math.cos(3.14*(roomLongitude)));
      distance = Math.acos(distance);            
      distance = Math.toDegrees(2)*distance;
      distance = distance * 60 * 1.1515;
      distance *= 1.609344;
      return Math.round(distance);
   }
   
   public double checkDistance1(double currentLatitude , double currentLongitude , double roomLatitude, double roomLongitude) {
      if(currentLatitude > 0&& roomLatitude > 0) {
         currentLatitude *= -1;
      }
      if(currentLongitude > 0 && roomLongitude > 0) {
         currentLongitude *= -1;
      }
      if(currentLongitude < 0&& roomLongitude < 0) {
         currentLongitude *= -1;
      }
      if(currentLatitude < 0 && roomLatitude < 0) {
         currentLatitude *= -1;
      }
      
      double distance = Math.sqrt(Math.pow(currentLatitude + roomLatitude, 2) + Math.pow(currentLongitude+roomLongitude, 2));
      return Math.round(distance);
   }
   
}