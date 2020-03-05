namespace Test2_Lege
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.nameTextBox = new System.Windows.Forms.TextBox();
            this.grade1TextBox = new System.Windows.Forms.TextBox();
            this.grade2TextBox = new System.Windows.Forms.TextBox();
            this.grade3TextBox = new System.Windows.Forms.TextBox();
            this.grade4TextBox = new System.Windows.Forms.TextBox();
            this.grade5TextBox = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.outputName = new System.Windows.Forms.Label();
            this.outputAverage = new System.Windows.Forms.Label();
            this.outputLetterGrade = new System.Windows.Forms.Label();
            this.calculateButton = new System.Windows.Forms.Button();
            this.clearButton = new System.Windows.Forms.Button();
            this.exitButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.Location = new System.Drawing.Point(32, 9);
            this.label1.Margin = new System.Windows.Forms.Padding(7, 0, 7, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(843, 40);
            this.label1.TabIndex = 0;
            this.label1.Text = "Please enter each students name and their 5 grades to recieve their average.";
            this.label1.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // nameTextBox
            // 
            this.nameTextBox.Location = new System.Drawing.Point(540, 52);
            this.nameTextBox.Name = "nameTextBox";
            this.nameTextBox.Size = new System.Drawing.Size(286, 31);
            this.nameTextBox.TabIndex = 1;
            // 
            // grade1TextBox
            // 
            this.grade1TextBox.Location = new System.Drawing.Point(546, 95);
            this.grade1TextBox.Name = "grade1TextBox";
            this.grade1TextBox.Size = new System.Drawing.Size(100, 31);
            this.grade1TextBox.TabIndex = 2;
            // 
            // grade2TextBox
            // 
            this.grade2TextBox.Location = new System.Drawing.Point(546, 132);
            this.grade2TextBox.Name = "grade2TextBox";
            this.grade2TextBox.Size = new System.Drawing.Size(100, 31);
            this.grade2TextBox.TabIndex = 3;
            // 
            // grade3TextBox
            // 
            this.grade3TextBox.Location = new System.Drawing.Point(546, 169);
            this.grade3TextBox.Name = "grade3TextBox";
            this.grade3TextBox.Size = new System.Drawing.Size(100, 31);
            this.grade3TextBox.TabIndex = 4;
            // 
            // grade4TextBox
            // 
            this.grade4TextBox.Location = new System.Drawing.Point(546, 206);
            this.grade4TextBox.Name = "grade4TextBox";
            this.grade4TextBox.Size = new System.Drawing.Size(100, 31);
            this.grade4TextBox.TabIndex = 5;
            // 
            // grade5TextBox
            // 
            this.grade5TextBox.Location = new System.Drawing.Point(546, 243);
            this.grade5TextBox.Name = "grade5TextBox";
            this.grade5TextBox.Size = new System.Drawing.Size(100, 31);
            this.grade5TextBox.TabIndex = 6;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(384, 59);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(150, 24);
            this.label2.TabIndex = 7;
            this.label2.Text = "Student\'s name: ";
            this.label2.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(349, 102);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(185, 24);
            this.label3.TabIndex = 8;
            this.label3.Text = "First Grade (number)";
            this.label3.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(318, 139);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(216, 24);
            this.label4.TabIndex = 9;
            this.label4.Text = "Second Grade (number)";
            this.label4.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(340, 176);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(194, 24);
            this.label5.TabIndex = 10;
            this.label5.Text = "Third Grade (number)";
            this.label5.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(329, 210);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(205, 24);
            this.label6.TabIndex = 11;
            this.label6.Text = "Fourth Grade (number)";
            this.label6.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label7.Location = new System.Drawing.Point(349, 250);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(185, 24);
            this.label7.TabIndex = 12;
            this.label7.Text = "Fifth Grade (number)";
            this.label7.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(284, 357);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(72, 25);
            this.label8.TabIndex = 13;
            this.label8.Text = "Name";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(522, 357);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(99, 25);
            this.label9.TabIndex = 14;
            this.label9.Text = "Average";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(673, 357);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(144, 25);
            this.label10.TabIndex = 15;
            this.label10.Text = "Letter Grade";
            // 
            // outputName
            // 
            this.outputName.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.outputName.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.outputName.Location = new System.Drawing.Point(184, 301);
            this.outputName.Name = "outputName";
            this.outputName.Size = new System.Drawing.Size(265, 47);
            this.outputName.TabIndex = 16;
            this.outputName.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // outputAverage
            // 
            this.outputAverage.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.outputAverage.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.outputAverage.Location = new System.Drawing.Point(494, 301);
            this.outputAverage.Name = "outputAverage";
            this.outputAverage.Size = new System.Drawing.Size(152, 47);
            this.outputAverage.TabIndex = 17;
            this.outputAverage.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // outputLetterGrade
            // 
            this.outputLetterGrade.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.outputLetterGrade.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.outputLetterGrade.Location = new System.Drawing.Point(691, 301);
            this.outputLetterGrade.Name = "outputLetterGrade";
            this.outputLetterGrade.Size = new System.Drawing.Size(103, 47);
            this.outputLetterGrade.TabIndex = 18;
            this.outputLetterGrade.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // calculateButton
            // 
            this.calculateButton.Location = new System.Drawing.Point(66, 423);
            this.calculateButton.Name = "calculateButton";
            this.calculateButton.Size = new System.Drawing.Size(198, 38);
            this.calculateButton.TabIndex = 19;
            this.calculateButton.Text = "Calculate";
            this.calculateButton.UseVisualStyleBackColor = true;
            this.calculateButton.Click += new System.EventHandler(this.calculateButton_Click);
            // 
            // clearButton
            // 
            this.clearButton.Location = new System.Drawing.Point(366, 423);
            this.clearButton.Name = "clearButton";
            this.clearButton.Size = new System.Drawing.Size(198, 38);
            this.clearButton.TabIndex = 20;
            this.clearButton.Text = "Clear";
            this.clearButton.UseVisualStyleBackColor = true;
            this.clearButton.Click += new System.EventHandler(this.clearButton_Click);
            // 
            // exitButton
            // 
            this.exitButton.Location = new System.Drawing.Point(658, 423);
            this.exitButton.Name = "exitButton";
            this.exitButton.Size = new System.Drawing.Size(198, 38);
            this.exitButton.TabIndex = 21;
            this.exitButton.Text = "Exit";
            this.exitButton.UseVisualStyleBackColor = true;
            this.exitButton.Click += new System.EventHandler(this.exitButton_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(13F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(918, 464);
            this.Controls.Add(this.exitButton);
            this.Controls.Add(this.clearButton);
            this.Controls.Add(this.calculateButton);
            this.Controls.Add(this.outputLetterGrade);
            this.Controls.Add(this.outputAverage);
            this.Controls.Add(this.outputName);
            this.Controls.Add(this.label10);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.grade5TextBox);
            this.Controls.Add(this.grade4TextBox);
            this.Controls.Add(this.grade3TextBox);
            this.Controls.Add(this.grade2TextBox);
            this.Controls.Add(this.grade1TextBox);
            this.Controls.Add(this.nameTextBox);
            this.Controls.Add(this.label1);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Margin = new System.Windows.Forms.Padding(7, 6, 7, 6);
            this.Name = "Form1";
            this.Text = "Grade Calculator";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox nameTextBox;
        private System.Windows.Forms.TextBox grade1TextBox;
        private System.Windows.Forms.TextBox grade2TextBox;
        private System.Windows.Forms.TextBox grade3TextBox;
        private System.Windows.Forms.TextBox grade4TextBox;
        private System.Windows.Forms.TextBox grade5TextBox;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label outputName;
        private System.Windows.Forms.Label outputAverage;
        private System.Windows.Forms.Label outputLetterGrade;
        private System.Windows.Forms.Button calculateButton;
        private System.Windows.Forms.Button clearButton;
        private System.Windows.Forms.Button exitButton;
    }
}

