using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _4_5
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void yellowRadioButton_CheckedChanged(object sender, EventArgs e)
        {
            if (yellowRadioButton.Checked)
            {
                this.BackColor = Color.Yellow;
            }
        }

        private void redRadioButton_CheckedChanged(object sender, EventArgs e)
        {
            if (redRadioButton.Checked)
            {
                this.BackColor = Color.Red;
            }

        }

        private void whiteRadioButton_CheckedChanged(object sender, EventArgs e)
        {
            if (whiteRadioButton.Checked)
            {
                this.BackColor = Color.White;
            }
        }

        private void normalRadioButton_CheckedChanged(object sender, EventArgs e)
        {
            if (normalRadioButton.Checked)
            {
                this.BackColor = SystemColors.Control;
            }
        }
    }
}
