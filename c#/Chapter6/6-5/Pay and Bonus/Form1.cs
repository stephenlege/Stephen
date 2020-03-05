using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Pay_and_Bonus
{
    public partial class Form1 : Form
    {
        //constant field for the contribution rate
        private const decimal CONTRIB_RATE = .05m;


        public Form1()
        {
            InitializeComponent();
        }

        //The inputisvalid method converts the user input and stores it in the arguments(passed by ref)
        //If the conversion is successful, the method returns true, otherwise false
        private bool InputIsValid(ref decimal pay, ref decimal bonus)
        {
            //Flag variable to indicate whether the input is good
            bool inputGood = false;

            //Try to convert both inputs to decimal
            if (decimal.TryParse(grossPayTextBox.Text, out pay))
            {
                if (decimal.TryParse(bonusTextBox.Text, out bonus))
                {
                    //Both inputs are good
                    inputGood = true;
                }
                else
                {
                    //display error message
                    MessageBox.Show("Bonus amount is invalid");
                }
            }
            else
            {
                //error for gross
                MessageBox.Show("Gross pay is invalid.");
            }
                //Return result
                return inputGood;
            
        }

        private void calculateButton_Click(object sender, EventArgs e)
        {
            //variables 
            decimal grossPay = 0m, bonus = 0m, contributions = 0m;

            if (InputIsValid(ref grossPay, ref bonus))
            {
                //calculate then display
                contributions = (grossPay + bonus) * CONTRIB_RATE;

                contributionLabel.Text = contributions.ToString("c");
            }

        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
