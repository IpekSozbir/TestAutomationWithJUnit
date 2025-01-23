package day12_excel_getScreenshot_jsExecutors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {

    @Test
    public void writeExcelTesti () throws IOException {
        // 1- Adimlari takip ederek Sayfa1'e kadar gidelim
        String dosyaYolu = "src/test/java/day11_webTables_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // 2- 1. satir 5. hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(4);

        // 3- Olusturdugumuz hucreye "Nufus" yazdiralim
        sayfa1.getRow(0).getCell(4).setCellValue("Nufus");

        // 4- 2. satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).createCell(4).setCellValue(1500000);

        // 5- 10.satir nufus kolonuna 2500000 yazdiralim
        sayfa1.getRow(9).createCell(4).setCellValue(2500000);

        // 6- 15.satir nufus kolonuna 540000 yazdiralim
        sayfa1.getRow(14).createCell(4).setCellValue(540000);

        // 7- bos olan ilk satira Ingilizce ulke ismi  JavaRepublic ingilizce baskent olarak Selenium yazdiralim
        int ilkBosSatirSayisi = sayfa1.getLastRowNum()+1;
        sayfa1.createRow(ilkBosSatirSayisi);
        sayfa1.getRow(ilkBosSatirSayisi).createCell(0).setCellValue("JavaRepublic");
        sayfa1.getRow(ilkBosSatirSayisi).createCell(1).setCellValue("Selenium");

        // 8- Dosyayi kaydedelim
        /*
        Yaptigimiz tum degisiklikleri workbook uzeirnde yaptik
        Workbook objesi fiziki excel dosyasindan fileInputstream ile aldigimiz bilgilerle olusturuldu
        ve excel'in bir kopyasi oldu
        Eger workbook uzerinde yaptigimiz degisiklikleri excel dosyasina islemek istiyorsak
        kaydetme islemi yapmamiz gerekir

        ONEMLİ!!!
        Workbook'da yaptigimiz degisiklikleri excel'e kaydetme islemi yapmadan once
        excel dosyasinin kapali oldugundan emin olmalisiniz
         */

        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);
        workbook.write(fileOutputStream);

        // 9- Dosyayi kapatalim
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }
}
