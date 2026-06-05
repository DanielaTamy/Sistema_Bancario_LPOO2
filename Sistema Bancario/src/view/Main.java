package view;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import model.dao.DatabaseSeeder;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        DatabaseSeeder.inicializarBanco();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaManterClientes telaPrincipal = new TelaManterClientes();
                telaPrincipal.setLocationRelativeTo(null);
                telaPrincipal.setVisible(true);
            }
        });
    }
}
