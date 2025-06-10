import javax.swing.JTextField;
import javax.swing.text.*;

public class LimitarCaracteres {

    // Limita os caracteres
    public static void limitarCaracteres(JTextField campo, int limite) {
    AbstractDocument doc = (AbstractDocument) campo.getDocument();
    doc.setDocumentFilter(new DocumentFilter() {
        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if ((fb.getDocument().getLength() + text.length() - length) <= limite) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            if ((fb.getDocument().getLength() + string.length()) <= limite) {
                super.insertString(fb, offset, string, attr);
            }
        }
    });
}}