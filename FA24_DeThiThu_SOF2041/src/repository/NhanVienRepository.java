/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.DBConnect;
import entity.NhanVien;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Huyen
 */
public class NhanVienRepository {
    public ArrayList<NhanVien> getAll(){
        ArrayList<NhanVien> lstNhanVien = new ArrayList<>();
        //1. viết câu truy vấn sql
        String sql = """
                     SELECT [MaNV]
                           ,[MatKhau]
                           ,[HoTen]
                           ,[VaiTro]
                       FROM [dbo].[NhanVien]
                     """;
       
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            //table -> kieu du lieu Result set
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //tao doi tuong
                NhanVien nv= new NhanVien();
                nv.setMaNV(rs.getInt(1));
                nv.setMatKhau(rs.getString(2));
                nv.setHoTen(rs.getString(3));
                nv.setVaiTro(rs.getString(4));
                //them doi tuong vao danh sach
                lstNhanVien.add(nv);
            }
            
        } catch (Exception e) {
                e.printStackTrace();
        }
        return lstNhanVien;
    }
    public static void main(String[] args) {
        System.out.println(new NhanVienRepository().getAll());
    }
}
