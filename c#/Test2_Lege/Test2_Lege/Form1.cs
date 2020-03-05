using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Test2_Lege
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        //declare global variables
        double grade1;
        double grade2;
        double grade3;
        double grade4;
        double grade5;
        double min;
        double average;
        char letterG;
        //create get values and parse them from the text boxes here

        public static void GetValues(string g1, string g2, string g3, string g4, string g5, out double grade1,
            out double grade2, out double grade3, out double grade4, out double grade5)
        {
            //double grade1, grade2, grade3, grade4, grade5;
            Double.TryParse(g1, out grade1);
            Double.TryParse(g2, out grade2);
            Double.TryParse(g3, out grade3);
            Double.TryParse(g4, out grade4);
            Double.TryParse(g5, out grade5);
            
            
        }
        public static void FindMin(double grade1, double grade2, double grade3, double grade4 , double grade5, out double min)
        {
         min = Math.Min( Math.Min( Math.Min(Math.Min(grade1, grade2), grade3), grade4) , grade5);
           

        }

        public static void CalcAverage(double grade1, double grade2, double grade3, double grade4, double grade5, double min, out double average)
        {
           average = ((grade1 + grade2 + grade3 + grade4 + grade5) - min)/4;
        }

        public static void LetterG(double average, out char letterG)
        {
            if (average >= 90)
                letterG = 'A';
           else if (average >= 80)
                letterG = 'B';
            else if (average >= 70)
                letterG = 'C';
            else if (average >= 60)
                letterG = 'D';
            else
                letterG = 'F';
        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void clearButton_Click(object sender, EventArgs e)
        {
            nameTextBox.Text = "";
            grade1TextBox.Text = "";
            grade2TextBox.Text = "";
            grade3TextBox.Text = "";
            grade4TextBox.Text = "";
            grade5TextBox.Text = "";
            outputName.Text = "";
            outputLetterGrade.Text = "";
            outputAverage.Text = "";


        }

        private void calculateButton_Click(object sender, EventArgs e)
        {
            GetValues(grade1TextBox.Text, grade2TextBox.Text, grade3TextBox.Text, grade4TextBox.Text, grade5TextBox.Text, out grade1, out grade2,
                out grade3, out grade4, out grade5);

             FindMin(grade1, grade2, grade3, grade4, grade5,out min);

            CalcAverage(grade1, grade2, grade3, grade4, grade5, min, out average);

            LetterG(average, out letterG);

            outputName.Text = nameTextBox.Text;
            outputAverage.Text = average.ToString();
            outputLetterGrade.Text = letterG.ToString();

        }
    }
}
