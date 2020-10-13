/**
 * Mark Chafin and Daniel Schrader
 * IST 1562
 * Phone Book GUI
 * This program creates a GUI phone book. You can add, edit, and delete contacts.
 */



import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class GUIphonebook {
    public static JFrame frmPhonebook;
    public static JTextField txtName;
    public static JTextField txtNumber;
    public static JTextField txtNotes;
    public static JTextPane txtAll;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUIphonebook window = new GUIphonebook();
                    window.frmPhonebook.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public GUIphonebook() throws Exception {
        initialize();
    }
    private void initialize() throws Exception {
        Phone_Book.readPhone_Book("phonebook.txt");
        Phone_Book.sortList();
        frmPhonebook = new JFrame();
        frmPhonebook.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
        frmPhonebook.setType(Type.UTILITY);
        frmPhonebook.setTitle("PHONEBOOK");
        frmPhonebook.setBounds(100, 100, 461, 503);
        frmPhonebook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainP = new JPanel();
        mainP.setBackground(Color.GRAY);
        frmPhonebook.getContentPane().add(mainP, BorderLayout.CENTER);
        mainP.setLayout(null);
        JButton btnNewButton = new JButton("Delete");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Phone_Book.deleteContact();
            }
        });
        btnNewButton.setBounds(-6, 5, 130, 29);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        mainP.add(btnNewButton);
        JButton btnAddContact = new JButton("Add Contact");
        btnAddContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Phone_Book.addContact();
                txtName.setText("Name");
                txtNumber.setText("Number");
                txtNotes.setText("Notes");
                Phone_Book.sortList();
                try {
                    Phone_Book.CopyPhoneBookToFile("Phonebook.txt");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnAddContact.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnAddContact.setBounds(139, 5, 140, 29);
        mainP.add(btnAddContact);
        JButton btnListContacts = new JButton("List Contacts");
        btnListContacts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Phone_Book.listAllContacts();
            }
        });
        btnListContacts.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnListContacts.setBounds(284, 5, 140, 29);
        mainP.add(btnListContacts);
        txtName = new JTextField();
        txtName.setFont(UIManager.getFont("Button.font"));
        txtName.setBounds(139, 81, 146, 26);
        txtName.setText("Name");
        mainP.add(txtName);
        txtName.setColumns(10);
        txtNumber = new JTextField();
        txtNumber.setFont(UIManager.getFont("Button.font"));
        txtNumber.setBounds(139, 141, 146, 26);
        txtNumber.setText("Number");
        mainP.add(txtNumber);
        txtNumber.setColumns(10);
        txtNotes = new JTextField();
        txtNotes.setFont(UIManager.getFont("Button.font"));
        txtNotes.setBounds(139, 193, 146, 26);
        txtNotes.setText("Notes");
        mainP.add(txtNotes);
        txtNotes.setColumns(10);
        txtAll = new JTextPane();
        final JScrollPane Window = new JScrollPane(txtAll);
        Window.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Window.setLocation(101, 260);
        Window.setSize(221, 129);
        mainP.add(Window);
    }
}