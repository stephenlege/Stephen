using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Seating_Chart
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

        private void displayPriceButton_Click(object sender, EventArgs e)
        {
            //variables for the selected row and column
            int row, col;

            //const for max row and col
            const int MAX_ROW = 5, MAX_COL = 3;

            //create array with the seat prices.
            decimal[,] prices = { { 450m, 450m, 450m, 450m},
                                  { 425m, 425m, 425m, 425m},
                                  { 400m, 400m, 400m, 400m},
                                  { 375m, 375m, 375m, 375m},
                                  { 375m, 375m, 375m, 375m},
                                  { 350m, 350m, 350m, 350m},
            };
            //get the selected row number
            if (int.TryParse(txtRow.Text, out row))
            {
                //get col number
                if (int.TryParse(txtCol.Text, out col))
                {
                    //make sure the ROW is within range.
                    if (row >= 0 && row <= MAX_ROW)
                    {
                        //make sure the col within range
                        if (col >= 0 && col <= MAX_COL)
                        {
                            //display the selected seat's price
                            priceLabel.Text = prices[row, col].ToString("c");
                        }
                        else
                        {
                            //error msg for col
                            MessageBox.Show("Column must be 0-" + MAX_COL);
                        }
                    }
                    else
                    {
                        //error for row
                        MessageBox.Show("Row must be 0-" + MAX_ROW);
                    }
                }
                else
                {
                    //display error for nonint col
                    MessageBox.Show("Please enter an integer for the column.");
                }

            }
            else
            {
                //display error message for noninteger row.
                MessageBox.Show("Please enter an int for the row.");
            }
        }
    }
}
