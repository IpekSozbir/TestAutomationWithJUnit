package day11_webTables_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel {

    @Test
    public void test01 () throws IOException {

     // Gerekli ayarlamalari yapip, ulkeler excel'indeki sayfa2'ye gidin

        // 1. adim dosya yolunu alalim
        String dosyaYolu = "src/test/java/day11_webTables_ExcelOtomasyon/ulkeler.xlsx";

        // 2. adim Java ile dosyaya erismek icin
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        // 3. adim excel'den alinan bilgileri
        // kodlarimizin icinde olusturacagimiz bir obje olarak kaydedelim
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa2Obj = workbook.getSheet("Sayfa2");


        // Kullanilan son satirin 20.satir oldugunu test edin
        int expectedSonSatirSayisi = 20;
        int actualSonSatirSayisi = sayfa2Obj.getLastRowNum()+1;
        Assertions.assertEquals(expectedSonSatirSayisi,actualSonSatirSayisi);


      // Kullanilan (bos birakilmayan) satir sayisinin 8 oldugunu test edin
        int expectedKullanilanSatirSayisi = 8;
        int actualKullanilanSatirSayisi = sayfa2Obj.getPhysicalNumberOfRows();
        Assertions.assertEquals(expectedKullanilanSatirSayisi,actualKullanilanSatirSayisi);

        //17. satir 5. hucredeki bilgiyi yazdirin
        System.out.println(sayfa2Obj.getRow(16).getCell(4)); // null
             // 17.satir kullaniliyor faakr 5. sutun bos oldugu icin null dondu


      // 5.satir 3.hucredeki bilgiyi yazdirin
        System.out.println(sayfa2Obj.getRow(4)); //  null
        System.out.println(sayfa2Obj.getRow(4).getCell(2)); // NullPointerException


        /*
        Olmayan bir satiri veya
        olan satirda deger atanmayan hucreyi yazdirmak isterseniz
        null yazdirilir

        Ancak olmayan bir satirda hucre degerini isterseniz
        NullPointerException olusur
         */
    }
}