/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sgv;

/**
 *
 * @author Eric e Samara
 */
import java.math.BigDecimal;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import br.com.sgv.model.Produto;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelService {

    public List<Produto> lerPlanilha(InputStream is) throws Exception {
        List<Produto> listaEstoque = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(is);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                // Pula a linha de cabeçalho
                continue;
            }

            Produto item = new Produto();
            item.setNome(row.getCell(0).getStringCellValue());
            item.setQuantidadeEstoque((int) row.getCell(1).getNumericCellValue());
            item.setPreco(BigDecimal.valueOf(row.getCell(2).getNumericCellValue()));

            listaEstoque.add(item);
        }
        workbook.close();
        return listaEstoque;
    }
}

