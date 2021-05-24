package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class NewOnlinePage extends Utils
{   LoadProperty loadProperty = new LoadProperty();
    //class locators
    private By _commentTitle = By.cssSelector("input#AddNewComment_CommentTitle");
    private By _comment = By.cssSelector("#AddNewComment_CommentText");
    private By _commentButton = By.xpath("//button[contains(@class,'item-add')]");
    private By _actualCommentVerification = By.cssSelector("div.result");
    private By _commentsBox = By.cssSelector("div.comments");
    private By _totalComments = By.cssSelector("div.comment.news-comment");
    private By _waitForClickable = By.cssSelector("button#newsletter-subscribe-button");

    //test data
    String commentText = loadProperty.getProperty("comment") + dateStamp();

    public void typeCommentDetails()
    {
//     waitForClickable(_waitForClickable,120);
       sleep(5000);
       //entering comment title
       enterText(_commentTitle,loadProperty.getProperty("commentTitle") + dateStamp());
       //entering comment
       enterText(_comment,commentText);
       //clicking on new comment button
       clickOnElement(_commentButton);
    }
    public void verifyCommentAddedSuccessfully()
    {   //verify comment added successfully
        Assert.assertEquals(getTextFromElement(_actualCommentVerification),"News comment is successfully added.","Comment not added successfully");
        System.out.println(loadProperty.getProperty("commentAdded"));
    }
    public void verifyCommentPresentInComments()
    {   //verify comment is present in comment list
        Assert.assertTrue(getTextFromElement(_commentsBox).contains(commentText),"latest added comment is not present in comment list");
        System.out.println(loadProperty.getProperty("commentPresent"));
    }
    public void verifyNewCommentAddedLastInTheList()
    {   //find total comments list
        List<WebElement> commentList = driver.findElements(_totalComments);
        //find last comment index from total comments
        int totalComments = commentList.size()-1;
        //get whole text of last comment
        String actualTextOfLastComment = commentList.get(totalComments).getText();
        //verifying last comments contains text of newly added comment
        Assert.assertTrue(actualTextOfLastComment.contains(commentText),"newly added comment is not present at last in comment list");
        System.out.println(loadProperty.getProperty("newCommentAdded"));
    }

}
