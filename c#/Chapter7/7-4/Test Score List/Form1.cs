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

namespace Test_Score_List
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }


        //the readscores method reads the scores from
        //TestScores.txt file into parameter
        private void ReadScores(List<int> scoresList)
        {
            try
            {
                //this is to save location of file and pull the directory
                string executableLocation = Path.GetDirectoryName(
                    Assembly.GetExecutingAssembly().Location);
                string txtLocation = Path.Combine(executableLocation, "TestScores.txt");

                //open the txt file
                StreamReader inputFile = File.OpenText(txtLocation);

                //read the scores into the list.
                while (!inputFile.EndOfStream)
                {
                    scoresList.Add(int.Parse(inputFile.ReadLine()));
                }

                inputFile.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
        //displayscores method displays the contents of the
        //scoresList param in the LIstBox cntr
        private void DisplayScores(List<int> scoresList)
        {
            foreach (int score in scoresList)
                testScoresListBox.Items.Add(score);

        }

        //avg method returns the avg of values in the scoresList param
        private double Average(List<int> scoresList)
        {
            int total = 0;          //accumulator
            double average;         //To hold the average

            //calc the total of the scores
            foreach (int score in scoresList)
                total += score;

            //calc the avg of the scores.
            average = (double)total / scoresList.Count;

            //return the average.
            return average;
        }

        //The AboveAverage method returns the number of
        //above avg scores in scoresList.
        private int AboveAverage(List<int> scoresList)
        {
            int numAbove = 0;       //accumulator

            //get the avg
            double avg = Average(scoresList);

            //count the number of above average scores.
            foreach (int score in scoresList)
            {
                if (score > avg)
                    numAbove++;
            }
            //return numAbove
            return numAbove;
        }
        //calc the below avg method that returns
        private int BelowAverage(List<int> scoresList)
        {
            int numBelow = 0;           //accumulator

            //get avg
            double avg = Average(scoresList);

            //count the number of below avg scores
            foreach (int score in scoresList)
            {
                if (score < avg)
                    numBelow++;
            }
            return numBelow;
            
        }

        private void exitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }



        private void getScoresButton_Click(object sender, EventArgs e)
        {
            double averageScore;        //to hold avg score
            int numAboveAverage;        //to hold number of above average scores;
            int numBelowAverage;        //Number of below average scores

            //create a list to hold scores
            List<int> scoresList = new List<int>();

            //read the scores from the file into the list
            ReadScores(scoresList);

            //display scores
            DisplayScores(scoresList);

            //display avg score
            averageScore = Average(scoresList);
            AverageLabel.Text = averageScore.ToString("n1");

            //display the num above avg scores
            numAboveAverage = AboveAverage(scoresList);
            aboveAverageLabel.Text = numAboveAverage.ToString();

            //display the number of below avg scores
            numBelowAverage = BelowAverage(scoresList);
            belowAverageLabel.Text = numBelowAverage.ToString();

                
            }
    }
}
