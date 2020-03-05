namespace SlotMachineFun
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
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.label1 = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.pictureBox3 = new System.Windows.Forms.PictureBox();
            this.fruitList = new System.Windows.Forms.ImageList(this.components);
            this.inputBet = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.spinButton = new System.Windows.Forms.Button();
            this.winLabel = new System.Windows.Forms.Label();
            this.loseLabel = new System.Windows.Forms.Label();
            this.outputBet = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.BackColor = System.Drawing.Color.Maroon;
            this.label1.Font = new System.Drawing.Font("Mistral", 48F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.Black;
            this.label1.Location = new System.Drawing.Point(208, -1);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(352, 63);
            this.label1.TabIndex = 0;
            this.label1.Text = "Test Your Luck!";
            this.label1.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(128)))));
            this.pictureBox1.Location = new System.Drawing.Point(128, 106);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(164, 170);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 2;
            this.pictureBox1.TabStop = false;
            // 
            // pictureBox2
            // 
            this.pictureBox2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(128)))));
            this.pictureBox2.Location = new System.Drawing.Point(298, 106);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(164, 170);
            this.pictureBox2.TabIndex = 3;
            this.pictureBox2.TabStop = false;
            // 
            // pictureBox3
            // 
            this.pictureBox3.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(192)))), ((int)(((byte)(128)))));
            this.pictureBox3.Location = new System.Drawing.Point(468, 106);
            this.pictureBox3.Name = "pictureBox3";
            this.pictureBox3.Size = new System.Drawing.Size(164, 170);
            this.pictureBox3.TabIndex = 4;
            this.pictureBox3.TabStop = false;
            // 
            // fruitList
            // 
            this.fruitList.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("fruitList.ImageStream")));
            this.fruitList.TransparentColor = System.Drawing.Color.Transparent;
            this.fruitList.Images.SetKeyName(0, "Banana.bmp");
            this.fruitList.Images.SetKeyName(1, "Apple.bmp");
            this.fruitList.Images.SetKeyName(2, "Cherries.bmp");
            this.fruitList.Images.SetKeyName(3, "Grapes.bmp");
            this.fruitList.Images.SetKeyName(4, "Lemon.bmp");
            this.fruitList.Images.SetKeyName(5, "Lime.bmp");
            this.fruitList.Images.SetKeyName(6, "Orange.bmp");
            this.fruitList.Images.SetKeyName(7, "Pear.bmp");
            this.fruitList.Images.SetKeyName(8, "Strawberry.bmp");
            this.fruitList.Images.SetKeyName(9, "Watermelon.bmp");
            // 
            // inputBet
            // 
            this.inputBet.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.inputBet.Location = new System.Drawing.Point(300, 411);
            this.inputBet.Name = "inputBet";
            this.inputBet.Size = new System.Drawing.Size(162, 29);
            this.inputBet.TabIndex = 5;
            this.inputBet.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // label2
            // 
            this.label2.BackColor = System.Drawing.Color.Gray;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.SystemColors.ControlText;
            this.label2.Location = new System.Drawing.Point(322, 379);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(118, 29);
            this.label2.TabIndex = 6;
            this.label2.Text = "Bet Money!";
            this.label2.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // spinButton
            // 
            this.spinButton.ForeColor = System.Drawing.SystemColors.Control;
            this.spinButton.Image = global::SlotMachineFun.Properties.Resources.handle2;
            this.spinButton.ImageAlign = System.Drawing.ContentAlignment.TopCenter;
            this.spinButton.Location = new System.Drawing.Point(638, 26);
            this.spinButton.Name = "spinButton";
            this.spinButton.Size = new System.Drawing.Size(75, 287);
            this.spinButton.TabIndex = 8;
            this.spinButton.Text = "Pull";
            this.spinButton.TextAlign = System.Drawing.ContentAlignment.BottomCenter;
            this.spinButton.UseVisualStyleBackColor = true;
            this.spinButton.Click += new System.EventHandler(this.spinButton_Click);
            // 
            // winLabel
            // 
            this.winLabel.BackColor = System.Drawing.SystemColors.Control;
            this.winLabel.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.winLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.winLabel.Image = global::SlotMachineFun.Properties.Resources.coins;
            this.winLabel.ImageAlign = System.Drawing.ContentAlignment.TopCenter;
            this.winLabel.Location = new System.Drawing.Point(242, 176);
            this.winLabel.Name = "winLabel";
            this.winLabel.Size = new System.Drawing.Size(285, 34);
            this.winLabel.TabIndex = 9;
            this.winLabel.Text = "You Win!";
            this.winLabel.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            this.winLabel.Visible = false;
            // 
            // loseLabel
            // 
            this.loseLabel.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.loseLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.loseLabel.ForeColor = System.Drawing.Color.Yellow;
            this.loseLabel.Location = new System.Drawing.Point(294, 279);
            this.loseLabel.Name = "loseLabel";
            this.loseLabel.Size = new System.Drawing.Size(176, 23);
            this.loseLabel.TabIndex = 10;
            this.loseLabel.Text = "Sorry, No Match.";
            this.loseLabel.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            this.loseLabel.Visible = false;
            // 
            // outputBet
            // 
            this.outputBet.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.outputBet.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.outputBet.Location = new System.Drawing.Point(323, 329);
            this.outputBet.Name = "outputBet";
            this.outputBet.Size = new System.Drawing.Size(117, 39);
            this.outputBet.TabIndex = 11;
            this.outputBet.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.outputBet.Visible = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = global::SlotMachineFun.Properties.Resources._018;
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(832, 482);
            this.Controls.Add(this.outputBet);
            this.Controls.Add(this.loseLabel);
            this.Controls.Add(this.winLabel);
            this.Controls.Add(this.spinButton);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.inputBet);
            this.Controls.Add(this.pictureBox3);
            this.Controls.Add(this.pictureBox2);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.PictureBox pictureBox3;
        private System.Windows.Forms.TextBox inputBet;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button spinButton;
        private System.Windows.Forms.Label winLabel;
        private System.Windows.Forms.Label loseLabel;
        private System.Windows.Forms.Label outputBet;
        public System.Windows.Forms.ImageList fruitList;
    }
}

