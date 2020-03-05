using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace Phonebook
{
    struct PhoneBookEntry
    {
        public string name;
        public string phone;
    }
    public partial class Form1 : Form
    {
        private List<PhoneBookEntry> phoneList = new List<PhoneBookEntry>();

        public Form1()
            

        {
            InitializeComponent();
        }

        private void ReadFile()
        {
            try
            {
                StreamReader inputFile;
                string line;

                PhoneBookEntry entry = new PhoneBookEntry();

                char[] delim = { ',' };

                inputFile = File.OpenText("PhoneList.txt");

                while (!inputFile.EndOfStream)
                {
                    line = inputFile.ReadLine();

                    string[] tokens = line.Split(delim);

                    entry.name = tokens[0];
                    entry.phone = tokens[1];

                    phoneList.Add(entry);
                }
            }
            catch ( Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
        
        private void DisplayNames()
        {
            foreach (PhoneBookEntry entry in phoneList)
            {
                nameListBox.Items.Add(entry.name);
            }
        }

        private void nameListBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            //get
            int index = nameListBox.SelectedIndex;

            //display
            phoneLabel.Text = phoneList[index].phone;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //read
            ReadFile();

            //display
            DisplayNames();
        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
