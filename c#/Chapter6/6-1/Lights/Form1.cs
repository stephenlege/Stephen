using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Lights
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private void TurnLightOn()
        {
            //display the "light on" image
            lightOnPictureBox.Visible = true;

            //hide light off
            lightOffPictureBox.Visible = false;

            //display state
            lightStateLabel.Text = "ON";
        }

        private void TurnLightOff()
        {
            //display lights off
            lightOffPictureBox.Visible = true;

            //hide light on
            lightOnPictureBox.Visible = false;

            //display state
            lightStateLabel.Text = "OFF";
        }

        private void switchButton_Click(object sender, EventArgs e)
        {
            //Reverse state of the light
            if (lightOnPictureBox.Visible == true)
            {
                TurnLightOff();
            }
            else
            {
                TurnLightOn();
            }
        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
