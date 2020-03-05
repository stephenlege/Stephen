using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _5_8
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

        private void tossButton_Click(object sender, EventArgs e)
        {
            //variable to indicate which side is up
            int sideUp;

            //create a random object
            Random rand = new Random();

            //get a random int 0-1
            //0 means tails and 1 means heads
            sideUp = rand.Next(2);

            //display the side that is up
            if (sideUp == 0)
            {
                //display tails
                tailsPictureBox.Visible = true;
                headsPictureBox.Visible = false;
            }
            else
            {
                //display heads
                headsPictureBox.Visible = true;
                tailsPictureBox.Visible = false;
            }

        }
    }
}
