using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Ending_Balance
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void calculateButton_Click(object sender, EventArgs e)
        {
            //constant for the monthly interest rate.
            const decimal INTEREST_RATE = 0.005m;

            //Local variables
            decimal balance;
            int months;
            int count = 1;

            //get starting balance
            if (decimal.TryParse(startingBalTextBox.Text, out balance))
            {
                //get #months
                if (int.TryParse(monthsTextBox.Text, out months))
                {
                    //run a loop to calc ending balance
                    while (count <= months)
                    {
                        //add this month's interest to the balance.
                        balance = balance + (INTEREST_RATE * balance);

                        //display this month's ending balance.
                        detailListBox.Items.Add("The ending balance " +
                            "for month " + count + " is " + balance.ToString("c"));

                        //add one to the loop counter
                        count += 1;

                    }

                    //Display the ending balance
                    endingBalanceLabel.Text = balance.ToString("c");
                }
                else
                {
                    //Invalid input for months
                    MessageBox.Show("Invalid value for months.");
                }

            }
            else
            {
                //invalid input for starting blance
                MessageBox.Show("Invalid value for starting balance.");
            }

        }

        private void clearButton_Click(object sender, EventArgs e)
        {
            //clearthe text boxes, the label and the listbox
            startingBalTextBox.Text = "";
            monthsTextBox.Text = "";
            endingBalanceLabel.Text = "";
            detailListBox.Items.Clear();

            //reset focus
            startingBalTextBox.Focus();
        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
