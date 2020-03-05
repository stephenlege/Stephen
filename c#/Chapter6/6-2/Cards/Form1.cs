using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Cards
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        //The showcard method accepts a string that names the selected card, then displays
        private void ShowCard(string card)
        {
            switch (card)
            {
                case "Ace of Spades":
                    ShowAceSpades();
                    break;
                case "10 of Hearts":
                    ShowTenHearts();
                    break;
                case "King of Clubs":
                    ShowKingClubs();
                    break;
            }

        }

        //the ShowAceSpades method makes ace of spades visible and other cards invis
        private void ShowAceSpades()
        {
            aceSpadesPictureBox.Visible = true;
            tenHeartsPictureBox.Visible = false;
            kingClubsPictureBox.Visible = false;
        }

        //show 10 hearts
        private void ShowTenHearts()
        {
            tenHeartsPictureBox.Visible = true;
            aceSpadesPictureBox.Visible = false;
            kingClubsPictureBox.Visible = false;
        }

        //show king clubs
        private void ShowKingClubs()
        {
            kingClubsPictureBox.Visible = true;
            aceSpadesPictureBox.Visible = false;
            tenHeartsPictureBox.Visible = false;
        }

        private void showCardButton_Click(object sender, EventArgs e)
        {
            //if a card is selected in the listbox, display it
            if (cardListBox.SelectedIndex != -1)
            {
                ShowCard(cardListBox.SelectedItem.ToString());
            }
            else
            {
                MessageBox.Show("Please select a card from the list box!");
            }
        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
