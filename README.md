# Android-Projects
This repository contains android projects which i performing in my daily routin.

----------------------------------------------------------------------------------

### Base64 Stuff 
Use file *Base64Util.java*

----------------------------------------------------------------------------------

### Invoke OnClick to RecyclerView Programmatically 
```
myRecycerView.postDelayed(new Runnable() {
       @Override
       public void run() {
          for (int i = 0; i < arrayList.size(); i++) {
              if (myRecycerView.findViewHolderForAdapterPosition(i) != null) {
                  Objects.requireNonNull(myRecycerView.findViewHolderForAdapterPosition(i))
                        .itemView
                        .findViewById(R.id.imageView)
                        .performClick();
              }
          }
      }
 }, 100);
```
----------------------------------------------------------------------------------
