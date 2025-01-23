package day12_excel_getScreenshot_jsExecutors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01 () throws IOException {
        // Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin

             // 1. adim dosya yolunu alalim
        String dosyaYolu = "src/test/java/day11_webTables_ExcelOtomasyon/ulkeler.xlsx";

             // 2. adim Java ile dosyaya erismek icin
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

             // 3. adim excel'den alinan bilgileri
             // kodlarimizin icinde olusturacagimiz bir obje olarak kaydedelim
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1Obj = workbook.getSheet("Sayfa1");


        //  1.satirdaki 2.hucreye gidin ve yazdirin
        System.out.println(sayfa1Obj.getRow(0).getCell(1)); // Başkent (İngilizce)


        //  1.satirdaki 2.hucreyi bir string degiskene atayin ve degerinin “Başkent (İngilizce)” oldugunu test edin
        String expectedSatir1Hucre2 = "Başkent (İngilizce)";
        String actualSatir1Hucre2 = sayfa1Obj.getRow(0).getCell(1).getStringCellValue();
        Assertions.assertEquals(expectedSatir1Hucre2,actualSatir1Hucre2);


        //- 2.satir 4.cell’in Afganistan’in baskenti “Kabil” oldugunu test edin
        String expectedSatir2Hucre4 = "Kabil";
        String actualSatir2Hucre4 = sayfa1Obj.getRow(1).getCell(3).getStringCellValue();
        Assertions.assertEquals(expectedSatir2Hucre4,actualSatir2Hucre4);


        // - Ulke sayisinin 190 oldugunu test edin
        int actualUlkeSayisi = sayfa1Obj.getLastRowNum()+1-1;
        int expectedUlkeSayisi = 190;
        // +1 method index getirdigi icin
        // -1 en basta baslik satiri oldugu icin
        Assertions.assertEquals(expectedUlkeSayisi,actualUlkeSayisi);


        // - Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin
        int expectedKullanilanSatirSayisi = 191;
        int actualKullanilanSatirSayisi = sayfa1Obj.getPhysicalNumberOfRows();
        Assertions.assertEquals(expectedKullanilanSatirSayisi,actualKullanilanSatirSayisi);


        // - Ingilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin
                // butun satirlari tek tek kontrol edip
                // 0. index'deki data Netherlands ise 3. index'deki datanin Amsterdam oldugunu kontrol edelim
        for (int i = 1; i <=sayfa1Obj.getLastRowNum() ; i++) {
            String satirdakiUlkeIsmi = sayfa1Obj.getRow(i).getCell(0).getStringCellValue();
            if (satirdakiUlkeIsmi.equals("Netherlands")) {
                String actualTurkceUlkeIsmi = sayfa1Obj.getRow(i).getCell(3).getStringCellValue();
                Assertions.assertEquals("Amsterdam",actualTurkceUlkeIsmi);
                break;
            }
        }


        //- Turkce baskent isimlerinde Ankara bulundugunu test edin
        boolean ankaraVarMi = false;
        for (int i = 1; i <sayfa1Obj.getLastRowNum() ; i++) {
            String satirdakiTurkceBaskentIsmi = sayfa1Obj.getRow(i).getCell(3).getStringCellValue();
            if (satirdakiTurkceBaskentIsmi.equals("Ankara")) {
                ankaraVarMi = true;
                break;
            }
        }
        Assertions.assertTrue(ankaraVarMi);
    }
}
