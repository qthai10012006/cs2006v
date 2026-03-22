/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package buoi6;
import data.NhanVien;
import data.TruongPhong;
import data.ThucTapSinh;
import data.LapTrinhVien;
import data.NganHang;
import java.util.Scanner;



/**
 *
 * @author DELL
 */
public class Buoi6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){ 
            
             Scanner sc = new Scanner(System.in);
        double luong;

        
        while (true) {
            try {
                System.out.print("Nhap luong: ");

                luong = Double.parseDouble(sc.nextLine());

                if (luong < 0) {
                    throw new Exception("Luong khong duoc am");
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Loi: phai nhap so!");
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage());
            }
        }

        System.out.println("Luong hop le: " + luong);

        
        System.out.print("Nhap tu so: ");
        int tu = Integer.parseInt(sc.nextLine());

        
        while (true) {
            try {

                System.out.print("Nhap mau so: ");
                int mau = Integer.parseInt(sc.nextLine());

                int ketQua = tu / mau;

                System.out.println("Ket qua = " + ketQua);

                break;

            } catch (ArithmeticException e) {
                System.out.println(" Loi: Mau khong duoc bang 0");
            } catch (NumberFormatException e) {
                System.out.println(" Loi: phai nhap so");
            }
        }

    }
            
            
            
            
            
            
        
    }

        
    
        // TODO code application logic here
        //System.out.println("nhan vien ");
        //NhanVien nv1 = new NhanVien("A",1000);
        ///System.out.println(nv1);
        //NhanVien tts = new ThucTapSinh("c", 5_000_000, "DH Bach Khoa");
        //NhanVien ltv = new LapTrinhVien("D", 10_000_000, 20);

        //System.out.println(tts);
        //System.out.println(ltv);
        //new LapTrinhVien("An", 7000000, 5);
        //new ThucTapSinh("Bình", 4000000, "HUTECH");
        //new TruongPhong("Cường", 15000000, 3000000);

        //System.out.println("Tổng nhân viên: " + NhanVien.tongNhanVien);
        //System.out.println("congty cua truong phong la" + NhanVien.tenCongTy);
        //NganHang kh1 = new NganHang("An", 10000000, 0.06, 3);

        //System.out.println(kh1);
         //Scanner sc = new Scanner(System.in);

        //System.out.println("Nhap loai nhan vien:");
        //System.out.println("1. Nhan vien");
        //System.out.println("2. Truong phong");
        //System.out.println("3. Thuc tap sinh");
        //System.out.println("4. Lap trinh vien");

        //int choice = sc.nextInt();
        //sc.nextLine(); // xóa bộ nhớ đệm

        //System.out.print("Nhap ten: ");
        //String ten = sc.nextLine();

        //System.out.print("Nhap luong co ban: ");
        //double luong = sc.nextDouble();

        //NhanVien nv = null;

        //switch (choice) {

           // case 1:
                //nv = new NhanVien(ten, luong);
                //break;

            //case 2:
                //System.out.print("Nhap tien trach nhiem: ");
                //double trachNhiem = sc.nextDouble();
                //nv = new TruongPhong(ten, luong, trachNhiem);
              //  break;

            //case 3:
                //sc.nextLine();
                //System.out.print("Nhap truong dai hoc: ");
                //String truong = sc.nextLine();
                //nv = new ThucTapSinh(ten, luong, truong);
              //  break;

            //case 4:
                //System.out.print("Nhap so gio OT: ");
                //int ot = sc.nextInt();
                //nv = new LapTrinhVien(ten, luong, ot);
              //  break;

            //default:
            //    System.out.println("Lua chon khong hop le");
          //      return;
        //}

        //System.out.println("----- THONG TIN NHAN VIEN -----");
        //System.out.println(nv);
        //System.out.println("Luong = " + nv.tinhLuong());
          
        

        

    
      
        








// khi thong tin sai chuong trinh yeu cau nguoi dung nhap lai thong tin
     // ưhile ( true)
             // lupng = sc.nestdouble()
             //chặn số âm
             // lương = double.pasdouble
             // if 9 luong< 0
              //throw new ễcption ( loi ko dc âm)
              //break 
             
             
             
             
          // chăjn cố tìnhvnhaapj sai   
            // [ try {
            //luong = sc nextdouble() [ chuyển sang doble] { luong= double . parsedouble(sc.nextline ())
              //      brake
                //    }
             //catch ( exception e ){
             //sys.out.prin("loi, nhap thong ton lai")
             //sc.nextLine
            //int yob = sc.nextint(); or string yob = sc.nextline
            //sys.out.pri("yob"+yob)
    
             
             
            //}
             
             
             
             
             
             
             
             
             
             
             //]    
                      //if( luong>0){
                         // break;
                     // }
                     // else {
                      //    system.out.prin(" nhap lai thông tin")
                     // }
                     
                     
                     
                     
                     

    //}
    //int tu = intger . pas int ( sc.nexlin());
    //ưhile (true )
    //system.out.prin( nhap mau)
    //try {
      //  int mau = int. pás int ( sc.netline());
       //int name tu/mau;
        //break;
        
    //}
    //catch ( Arith e ){
    //sys .out.print ("loi: mau ko dc= 0")
    //catch ( InputMÍa  e){
            
      //      }
//}
    // tren lơp
   // sca sc = new scan ( sýtem.in)
    //sý . out prin ( " nhapten")
    //string ten = sc.nẽt line() next line luôn trả về kiêu chữ
    //sý . out prin ( " nhapten")
   // double luong = sc.nẽtdouble()
    //nhanvien nv2 = new nhanvien ( ten , luong);
    //system.out.prinl(" thong tin ns:" = n2);
    

        
  //  }
    // tinh tông nhan vien


//tinh tong tien luong
////phan sô nhap tư và mau , mau khac 0 , arithmerricException truyền vào bắt loi mau là 0, inputmismatchexception nhap sai kieu