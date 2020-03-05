using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Fuel_Economy_with_TryParse
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void calculateButton_Click(object sender, EventArgs e)
        {

            //declare variable
            double miles, gallons, mpg;

            //validate the textbox controls
            if (double.TryParse(milesTextBox.Text, out miles))
            {
                if (double.TryParse(gallonsTextBox.Text, out gallons))
                {

                    //calc mpg and display
                    mpg = miles / gallons;
                    mpgLabel.Text = mpg.ToString("n1");
                }

                else
                {
                    //display error
                    MessageBox.Show("Invalid input for gallons.");
                }
            }
            else
            {
                //display error message
                MessageBox.Show("Invalid input for miles.");
            }


        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
