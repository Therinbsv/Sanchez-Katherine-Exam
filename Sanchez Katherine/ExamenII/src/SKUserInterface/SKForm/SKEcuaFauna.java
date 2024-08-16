package SKUserInterface.SKForm;
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import SKBusines.SKBusinessLogic.SKHormigueroBL;
import SKDAC.SKDTO.SKHormigueroDTO;

public class SKEcuaFauna extends JFrame {

    private JTextField SKCedulaField;
    private JTextField SKNombreField;
    private JTable SKHormigueroTable;

    public SKEcuaFauna() {
        
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
            System.out.println("No se pudo aplicar el tema de FlatLaf.");
            e.printStackTrace();
        }

        
        SKSetupFrame();

        
        JPanel SKMainPanel = new JPanel();
        SKMainPanel.setLayout(new BorderLayout());

        
        JPanel SKTopPanel = new JPanel();
        SKTopPanel.setLayout(new BorderLayout());

        
        JPanel SKTitlePanel = new JPanel();
        SKTitlePanel.setLayout(new GridLayout(3, 1));

        JLabel SKTitleLabel = new JLabel("EcuaFauna 2K24A");
        SKTitleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        SKTitlePanel.add(SKTitleLabel);

        JPanel SKGlobalVarsPanel = new JPanel();
        SKGlobalVarsPanel.setLayout(new GridLayout(2, 2));

        SKGlobalVarsPanel.add(new JLabel("Cédula:"));
        SKCedulaField = new JTextField("172901117-9");
        SKCedulaField.setEditable(false);  
        SKGlobalVarsPanel.add(SKCedulaField);

        SKGlobalVarsPanel.add(new JLabel("Nombre:"));
        SKNombreField = new JTextField("Sanchez Katherine");
        SKNombreField.setEditable(false);  
        SKGlobalVarsPanel.add(SKNombreField);

        SKTitlePanel.add(SKGlobalVarsPanel);
        SKTopPanel.add(SKTitlePanel, BorderLayout.NORTH);

        SKMainPanel.add(SKTopPanel, BorderLayout.NORTH);

        
        JPanel SKExperimentPanel = new JPanel();
        SKExperimentPanel.setLayout(new GridBagLayout());
        GridBagConstraints SKConstraints = new GridBagConstraints();
        SKConstraints.insets = new Insets(5, 5, 5, 5); 

        
        SKConstraints.gridx = 0;
        SKConstraints.gridy = 0;
        SKConstraints.gridwidth = 1;
        SKConstraints.fill = GridBagConstraints.NONE;

        
        ImageIcon SKIcon = new ImageIcon("src/SKUserInterface/SKImages/hormiguero.png");
        Image SKImage = SKIcon.getImage().getScaledInstance(200, 55, Image.SCALE_SMOOTH);
        SKIcon = new ImageIcon(SKImage);
        JLabel SKImageLabel = new JLabel(SKIcon);
        SKExperimentPanel.add(SKImageLabel, SKConstraints);

        
        SKConstraints.gridx = 1;
        SKConstraints.gridy = 0;
        SKConstraints.gridwidth = 2;
        SKConstraints.fill = GridBagConstraints.HORIZONTAL;
        JButton SKHormigueroBtn = new JButton("crear hormiga larva");
        SKHormigueroBtn.setBackground(Color.DARK_GRAY); 
        SKHormigueroBtn.setForeground(Color.WHITE);
        SKExperimentPanel.add(SKHormigueroBtn, SKConstraints);

        
        SKConstraints.gridx = 0;
        SKConstraints.gridy = 1;
        SKConstraints.gridwidth = 1;
        JComboBox<String> SKGenoAlimentoCombo = new JComboBox<>(new String[]{"<GenoAlimento>","AX", "AXX", "AXY"});
        SKExperimentPanel.add(SKGenoAlimentoCombo, SKConstraints);

        
        SKConstraints.gridx = 0;
        SKConstraints.gridy = 2;
        JComboBox<String> SKIngestaNativaCombo = new JComboBox<>(new String[]{"<IngestaNativa>","Carnívoro", "Herbívoro", "Omnívoro", "Insectívoros"});
        SKExperimentPanel.add(SKIngestaNativaCombo, SKConstraints);

        
        SKConstraints.gridx = 1;
        SKConstraints.gridy = 1;
        JButton SKGenoAlimentoBtn = new JButton("alimentar con Genoalimento");
        SKGenoAlimentoBtn.setBackground(Color.DARK_GRAY); 
        SKGenoAlimentoBtn.setForeground(Color.WHITE);
        SKExperimentPanel.add(SKGenoAlimentoBtn, SKConstraints);

        SKConstraints.gridx = 1;
        SKConstraints.gridy = 2;
        JButton SKIngestaNativaBtn = new JButton("alimentar con Ingesta Nativa");
        SKIngestaNativaBtn.setBackground(Color.DARK_GRAY); 
        SKIngestaNativaBtn.setForeground(Color.WHITE);
        SKExperimentPanel.add(SKIngestaNativaBtn, SKConstraints);

        
        String[] columnNames = {"ID", "Tipo Hormiga", "Sexo Hormiga", "Ingesta Nativa", "Geno Alimento", "Catalogo Ub", "Estado"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        SKHormigueroTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(SKHormigueroTable);
        scrollPane.setPreferredSize(new Dimension(500, 200)); 
        SKConstraints.gridx = 0;
        SKConstraints.gridy = 3;
        SKConstraints.gridwidth = 3; 
        SKConstraints.fill = GridBagConstraints.BOTH;
        SKConstraints.weightx = 1.0;
        SKConstraints.weighty = 1.0;
        SKExperimentPanel.add(scrollPane, SKConstraints);

        loadSKHormigueroData(); 

        SKMainPanel.add(SKExperimentPanel, BorderLayout.CENTER);

        
        JPanel SKBottomPanel = new JPanel();
        SKBottomPanel.setLayout(new GridLayout(1, 2));

        JButton SKEliminarBtn = new JButton("Eliminar");
        JButton SKGuardarBtn = new JButton("Guardar");

        SKBottomPanel.add(SKEliminarBtn);
        SKBottomPanel.add(SKGuardarBtn);

        SKMainPanel.add(SKBottomPanel, BorderLayout.SOUTH);

        
        this.add(SKMainPanel);

        
        this.setVisible(true);
    }

    private void SKSetupFrame() {
        this.setTitle("EcuaFauna 2K24A");
        this.setSize(800, 600); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void loadSKHormigueroData() {
        try {
            SKHormigueroBL skHormigueroBL = new SKHormigueroBL();
            List<SKHormigueroDTO> hormigueroList = skHormigueroBL.getAll();
            
            DefaultTableModel model = (DefaultTableModel) SKHormigueroTable.getModel();
            model.setRowCount(0); 
            
            for (SKHormigueroDTO hormiguero : hormigueroList) {
                String ubicacion = skHormigueroBL.getUbicacion(hormiguero.getIdSKCatalogoUb());
                model.addRow(new Object[]{
                    hormiguero.getIdSKHormiguero(),
                    hormiguero.getSKTipoHormiga(),
                    hormiguero.getIdSKSexoHormiga(),
                    hormiguero.getIdSKIngestaNativa(),
                    hormiguero.getIdSKGenoAlimento(),
                    ubicacion, 
                    hormiguero.getSKEstado()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar datos de SKHormiguero.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SKEcuaFauna::new);
    }
}





