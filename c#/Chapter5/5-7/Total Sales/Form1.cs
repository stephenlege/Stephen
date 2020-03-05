using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace Total_Sales
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void calculateButton_Click(object sender, EventArgs e)
        {
            try
            {
                //variables
                decimal sales;
                decimal total = 0m;

                //declare a StreamReader var
                StreamReader inputFile;

                //open the file and get SR object
                inputFile = File.OpenText("C:\\Sales.txt");

                //read file's content
                while (!inputFile.EndOfStream)
                {
                    //get sale amount
                    sales = decimal.Parse(inputFile.ReadLine());

                    //Add the sales amount to total
                    total += sales;
                }
                //close file
                inputFile.Close();

                //Display total
                totalLabel.Text = total.ToString("c");

            }

            catch (Exception ex)
            {
                //Display
                MessageBox.Show(ex.Message);
            }
            
        }
    }
}
