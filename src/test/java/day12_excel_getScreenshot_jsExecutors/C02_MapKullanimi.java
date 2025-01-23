package day12_excel_getScreenshot_jsExecutors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_MapKullanimi {

    @Test
    public void test01 () throws IOException {

        // Eger Ingilizce ulke isimleri ve Turkce baskent isimleri ile
        // birden fazla test varsa
        // her seferinde for loop yapmak yerine
        // data'lara daha rahat ulasabilecegimiz bir Java objesi olan Map'e kaydedebiliriz

        String dosyaYolu = "src/test/java/day11_webTables_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1Obj = workbook.getSheet("Sayfa1");


        Map<String, String> ulkelerBaskentlerMapi = new TreeMap<>();
        for (int i = 1; i <sayfa1Obj.getLastRowNum() ; i++) {
            String ingilizceUlkeIsmi = sayfa1Obj.getRow(i).getCell(0).getStringCellValue();
            String turkceBaskentIsmi = sayfa1Obj.getRow(i).getCell(3).getStringCellValue();

            ulkelerBaskentlerMapi.put(ingilizceUlkeIsmi,turkceBaskentIsmi);
        }


        // - Ingilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin

        String istenenBaskent = ulkelerBaskentlerMapi.get("Netherlands");
        String expectedBaskent = "Amsterdam";

        //- Turkce baskent isimlerinde Ankara bulundugunu test edin

        Assertions.assertTrue(ulkelerBaskentlerMapi.containsValue("Ankara"));

        // Ulkeler excel'inde Ghana var mi test edin
        Assertions.assertTrue(ulkelerBaskentlerMapi.containsKey("Ghana"));

    }
}
