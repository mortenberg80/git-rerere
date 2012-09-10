# git rerere

Dummy project created in order to show how _git rerere_ works.

## Instructions

Clone repoistory:

    $ git clone git@github.com:mortenberg80/git-rerere.git

Enable rerere:

    $ git config rerere.enabled true


Checkout branch at diverged point:

    $ git checkout -b diverged_branch tag_diverged_branch

Rebase diverged branch towards master:

    $ git rebase master

You will get a merge conflict, as expected. But since we have enabled "rerere" you will see _"Recorded preimage for 'src/main/java/no/iterate/App.java'"_. This tells us that **rerere** is in play.

Fix merge conflict, add file and run:

    $ git rebase --continue
    
You will then see _"Recorded resolution for 'src/main/java/no/iterate/App.java'"_ which tells us that our resolution is recorded. But now we have a new conflict which we need to resolve. 

Fix merge conflict, add file and run:

    $ git rebase --continue
    
Now we have 2 resolutions stored in our ".git/rr-cache"-folder.

If we now abort this rebase, our resolving-work is not wasted:

    $ git rebase --abort
    
Now we are back to our starting point - _diverged_branch_. Running the same rebase again will give some other results than the first time:

    $ git rebase master

Gives the following output:
    
    ...
    CONFLICT (content): Merge conflict in src/main/java/no/iterate/App.java    
    Resolved 'src/main/java/no/iterate/App.java' using previous resolution.
    ...

If you edit the file now, you see that your previous resolution has been applied. The resolution does not auto commit, so you need to add the file manually before continuing the rebase.

    $ git add src/main/java/no/iterate/App.java
    $ git rebase --continue
    
    
This demonstrates how rerere works :)

For further investigation, you might want to check out the ".git/rr-cache"-folder, which stores resolutions.