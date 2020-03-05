using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Test_Score_Average
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void clearButton_Click(object sender, EventArgs e)
        {
            //clear all the text boxes
            test1TextBox.Text = "";
            test2TextBox.Text = "";
            test3TextBox.Text = "";
            averageLabel.Text = "";

            //reset focus to test1
            test1TextBox.Focus();
        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void calculateButton_Click(object sender, EventArgs e)
        {
            try
            {

                const double HiGH_SCORE = 95.0;   //high score value
                double test1, test2, test3, average;

                //get scores from TextBoxes
                test1 = double.Parse(test1TextBox.Text);
                test2 = double.Parse(test2TextBox.Text);
                test3 = double.Parse(test3TextBox.Text);

                //calculate the avg.
                average = (test1 + test2 + test3) / 3.0;

                //display avg. rounded to 2 decimal places
                averageLabel.Text = average.ToString("n1");

                //if avg. is high, then congratulate with msg. box
                if (average > HiGH_SCORE)
                {
                    MessageBox.Show("Congratulations! Great Job!");
                }
            }catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }


        }
    }
}
