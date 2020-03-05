using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;
using System.Reflection;

namespace Test_Average
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        



        //the average method accepts an int array argument
        //and retruns the average of the values in the array
        private double Average(int[] iArray)
        {
            int total = 0;    //accumulator, initialized to 0
            double average;     //to hold avg

            //step through the array, adding each element to accumulator
            for (int index = 0; index < iArray.Length; index++)
            {
                total += iArray[index];
            }

            //calculate the avg
            average = (double)total / iArray.Length;

            //return the average
            return average;
        }

        //the highest method accepts an int array argument
        //and returns the highest value in that array
        private int Highest(int[] iArray)
        {
            //declare a var to hold the high value, and 
            //initialize it with the first value in the array.
            int highest = iArray[0];

            //step throught the rest of the array, beggining at
            //element 1.  When a value greater than highest is found,
            //assign that value to highest.
            for (int index = 1; index < iArray.Length; index++)
            {
                if (iArray[index] > highest)
                    highest = iArray[index];

            }
            return highest;
        }

        //the lowest method accepts an int array argument
        //and returns the lowest value in that array
        private int Lowest(int[] iArray)
        {
            //declare a variable to hold the lowest value and
            //initialize it with the first value in the array
            int lowest = iArray[0];

            //step through the rest of array, begining at elemnt 1
            //when a value less than lowest is found, assign that value to lowest.

            for(int index = 1; index < iArray.Length; index++)
            {
                if (iArray[index] < lowest)
                    lowest = iArray[index];
            }
            //return lowest
            return lowest;
        }


        private void exitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void getScoresButton_Click(object sender, EventArgs e)
        {

            try
            {
                //experiment
                string executableLocation = Path.GetDirectoryName(
                    Assembly.GetExecutingAssembly().Location);
                string txtlocation = Path.Combine(executableLocation, "TestScores.txt");


                //local variables
                const int SIZE = 5;                 //number of tests
                int[] scores = new int[SIZE];       //Array of test scores
                int index = 0;                      //loop counter
                int highestScore;                   //to hold highest
                int lowestScore;                    //placeholder of lowest
                double averageScore;                //placeholder of avg score
                
                StreamReader inputFile = File.OpenText(txtlocation);             //experiment

                //Open the file and get a StreamReader object.
                //string xsltFile = Application.StartupPath + @"\\docx.xsl";
                //above one might help pull file?
                //Read the test scores into the array
               while (!inputFile.EndOfStream && index < scores.Length)
                {
                    scores[index] = int.Parse(inputFile.ReadLine());
                    index++;
                }

                //close the file.
                inputFile.Close();

                //display the test scores.
                foreach (int value in scores)
                {
                    testScoresListBox.Items.Add(value);

                }

                //Get the highest, lowest, and average scores.
                highestScore = Highest(scores);
                lowestScore = Lowest(scores);
                averageScore = Average(scores);

                //set display
                highScoreLabel.Text = highestScore.ToString();
                lowScoreLabel.Text = lowestScore.ToString();
                averageScoreLabel.Text = averageScore.ToString("n1");


            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
    }
}
