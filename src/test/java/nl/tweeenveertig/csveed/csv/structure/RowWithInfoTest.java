package nl.tweeenveertig.csveed.csv.structure;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RowWithInfoTest {

    @Test
    public void simpleWord() {
        RowWithInfo row = new RowWithInfo();
        row = addString(row, "Hello");
        RowReport report = row.reportOnColumn(0);
        assertEquals("Hello", report.getRow());
        assertEquals(0, report.getStart());
        assertEquals(5, report.getEnd());
    }

    @Test
    public void coupleOfWords() {
        RowWithInfo row = new RowWithInfo();
        row = addString(row, "Alpha");
        row.addCharacter(';');
        row = addString(row, "Beta");
        row.addCharacter(';');
        row = addString(row, "Gamma");
        RowReport report = row.reportOnColumn(2);
        assertEquals("Alpha;Beta;Gamma", report.getRow());
        assertEquals(11, report.getStart());
        assertEquals(16, report.getEnd());
    }

    @Test
    public void variousNonPrintables() {
        RowWithInfo row = new RowWithInfo();
        row = addString(row, "Alpha");
        row.addCharacter('\t');
        row = addString(row, "Beta");
        row.addCharacter('\t');
        row = addString(row, "Gamma");
        RowReport report = row.reportOnColumn(2);
        assertEquals("Alpha\\tBeta\\tGamma", report.getRow());
        assertEquals(13, report.getStart());
        assertEquals(18, report.getEnd());
    }

    @Test
    public void reportOnEndOfLine() {
        RowWithInfo row = new RowWithInfo();
        row = addString(row, "Alpha");
        row.addCharacter('\t');
        row = addString(row, "Beta");
        row.addCharacter('@');
        RowReport report = row.reportOnEndOfLine();
        assertEquals("Alpha\\tBeta@", report.getRow());
        assertEquals(12, report.getStart());
        assertEquals(12, report.getEnd());
    }

    protected RowWithInfo addString(RowWithInfo row, String text) {
        row.markStartOfColumn();
        for (char character : text.toCharArray()) {
            row.addCharacter(character);
        }
        row.addCell(text);
        return row;
    }

}