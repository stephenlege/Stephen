using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Payroll_with_Overtime
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void calculateButton_Click(object sender, EventArgs e)
        {
            try
            {
                //constants
                const decimal BASE_HOURS = 40m;
                const decimal OT_MULTIPLIER = 1.5m;

                //local variables
                decimal hoursWorked, hourlyPayRate, basePay, overtimeHours, overtimePay, grossPay;

                //get hours worked and hpayrate
                hoursWorked = decimal.Parse(hoursWorkedTextBox.Text);
                hourlyPayRate = decimal.Parse(hourlyPayRateTextBox.Text);

                //determin gross pay
                if (hoursWorked > BASE_HOURS)
                {
                    //CALCULATE THE BASE PAY without overtime
                    basePay = hourlyPayRate * BASE_HOURS;

                    //calc overtime
                    overtimeHours = hoursWorked - BASE_HOURS;

                    //calc overtime pay
                    overtimePay = overtimeHours * hourlyPayRate * OT_MULTIPLIER;

                    //calc overall gross
                    grossPay = basePay + overtimePay;
                }
                else
                {
                    //calc gross pay
                    grossPay = hoursWorked * hourlyPayRate;
                }
                //display the gross
                grossPayLabel.Text = grossPay.ToString("c");
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void clearButton_Click(object sender, EventArgs e)
        {
            //clear the textboxes and labels
            hoursWorkedTextBox.Text = "";
            hourlyPayRateTextBox.Text = "";
            grossPayLabel.Text = "";

            //reset focus
            hoursWorkedTextBox.Focus();
        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
