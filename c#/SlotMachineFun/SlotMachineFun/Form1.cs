using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Drawing;
using System.Media;

namespace SlotMachineFun
{
    public partial class Form1 : Form
    {

       /**
            public enum slotResults
        {
            Apple,
            Banana,
            Cherries,
            Grapes,
            Lemon,
            Lime,
            Orange,
            Pear,
            Strawberry,
            Watermelon
        }
    */

        
        Random image = new Random();
        int index1;
        int index2;
        int index3;

        public void SetImage()
        {
            
           
            int slot = image.Next(0,10);
            pictureBox1.Image = fruitList.Images[slot];
            index1  = slot;
            
            slot = image.Next(0,10);
            pictureBox3.Image = fruitList.Images[slot];
            index2 = slot;
            
            slot = image.Next(0,10);
            pictureBox2.Image = fruitList.Images[slot];
            index3 = slot;

            
        }
      


        public void DisplayWinLose()
        {
            double money = 0;
            SetImage();

            

            if (index1 == index2 && index2 == index3)
            {
                winLabel.Visible = true;
                outputBet.Visible = true;
                Double.TryParse(inputBet.Text, out money );
                money *= 3;
                outputBet.Text = money.ToString();
                System.Media.SystemSounds.Asterisk.Play();

            }

                
            else if (index1 == index2 || index2 == index3 || index1 == index3)
            {
                winLabel.Visible = true;
                outputBet.Visible = true;
                Double.TryParse(inputBet.Text, out money);
                money *= 2;
                outputBet.Text = money.ToString();
                System.Media.SystemSounds.Asterisk.Play();
            }

            else
            {
                loseLabel.Visible = true;
                outputBet.Visible = true;
                Double.TryParse(inputBet.Text, out money);
                outputBet.Text = "-" + money.ToString();
                System.Media.SystemSounds.Beep.Play();
            }
         
            
        }

        public Form1()
        {
            InitializeComponent();
            
        }


        private void spinButton_Click(object sender, EventArgs e)
        {

            
            winLabel.Visible = false;
            loseLabel.Visible = false;
            outputBet.Visible = false;

            DisplayWinLose();
            
            inputBet.Focus();

            
        }
    }
}
