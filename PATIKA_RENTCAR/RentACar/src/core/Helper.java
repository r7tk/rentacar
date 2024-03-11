package core;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static void setTheme() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            if ("Windows Classic".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
    }

    public static void showMsg(String str) {
        optionPaneTR();
        String msg;
        String title = switch (str) {
            case "fill" -> {
                msg = "Lüften Tüm alanları Doldurunuz.";
                yield "Hata!";
            }
            case "done" -> {
                msg = "İşlem Başarılı !";
                yield "Sonuç";
            }
            case "notFound" -> {
                msg = str + " Bulunamadı!";
                yield "Bulunamadı.";
            }
            case "error" -> {
                msg = " Hatalı İşlem Yaptınız!";
                yield "Hata !";
            }
            default -> {
                msg = str;
                yield "Mesaj";
            }
        };

        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);


    }
    public static boolean confirm(String str){
        optionPaneTR();
        String msg;
        if(str.equals("sure")){
            msg = "Bu İşlemi yapmak istediğinize emin misiniz ?";
        }else{
            msg = str;
        }
        return JOptionPane.showConfirmDialog(null,msg,"Emin Misiniz ?!",JOptionPane.YES_NO_OPTION) == 0 ;
    }


    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldListEmpty(JTextField[] fieldList) {
        for (JTextField field : fieldList) {
            if (isFieldEmpty(field)) return true;
        }
        return false;
    }

    public static int getLocationPoint(String type, Dimension size) {
        return switch (type) {
            case "x" -> (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y" -> (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
            default -> 0;
        };
    }
    public static void optionPaneTR(){
        UIManager.put("OptionPane.okButtonText","Tamam");
        UIManager.put("OptionPane.yesButtonText","Evet");
        UIManager.put("OptionPane.noButtonText","Hayır");
    }
}