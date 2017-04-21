# Freemaker_EmailTemplateEngineDemo
Freemaker template engine by apache is used to send emails, earlier people use velocity engine which is deprecated by apache, so freemaker is a replacement  of velocity.
Enter your host, username & password in application.properties under resources folder.
it accept json, below is the json format .

{
	"senderEmailId":"yourfriends@zestmoney.in",
	"receiverEmailId":"pankaj@zestmoney.in",
	"emailSubject":"Email using FreeMaker Template Engine",
	"receiverFirstName":"Pankaj",
	"receiverLastName":"Arora",
	"attachmentUrls":["http://che.org.il/wp-content/uploads/2016/12/pdf-sample.pdf", "http://che.org.il/wp-content/uploads/2016/12/pdf-sample.pdf"]
}


// this code is not accepting any attachments for now. i would code that for lator.
