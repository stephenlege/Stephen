using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Cups_To_Ounces
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        //CupsToOunces method accepts a number of cups as an argument and returns
        //the equivalent number of fluid ounces.
        private double CupsToOunces(double cups)
        {
            return cups * 8.0;
        }

        private void convertButton_Click(object sender, EventArgs e)
        {
            //Variables to hold cups and ounces
            double cups, ounces;

            //get number of cups
            if (double.TryParse(cupsTextBox.Text, out cups))
            {
                //convert
                ounces = CupsToOunces(cups);

                //display
                ouncesLabel.Text = ounces.ToString("n1");
            }
            else
            {
                //display error
                MessageBox.Show("Please enter a valid number.");
            }
        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
