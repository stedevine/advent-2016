package advent

object Main {
  // Sqaures with three sides
  def main(args: Array[String]): Unit = {
    val input =
      """330  143  338
  769  547   83
  930  625  317
  669  866  147
   15  881  210
  662   15   70
  273  277  707
   50  592  770
  280  313  407
  642  487  372
   94  619  295
  734  243  141
  220  141  515
  198  824  745
  210  787  964
  213  627  601
  918    4  447
  805  630  802
  711  237  987
  938  552  388
  643  405  779
  803  747  525
  917  832  631
  899  292  843
   81  206  445
  141  874  465
  177  974   54
  520  725  814
  271  958  554
  779  579  264
  358   18  257
  978   77  270
  984   88  131
  475  702  940
  183  756  160
  383  941  820
  806  142  646
  793  275  804
   53  272  368
  942  821  785
  863  830  902
  219   52  199
  473  479  351
  860  522  361
  890  240  216
   94  756  407
  310  189  468
  234  909  178
  889  667  756
  429  485  730
  825  405   30
  943  806  253
   98  455  365
  998  454  290
  971  576  223
   64  429  273
  945  779   63
  352  960   59
  672  948  577
  782   43  567
  460  315  719
  825  604  183
  453  442  788
  694  632  334
  569  619  317
  337   49   17
  878  468  660
  393  598  717
  550  827  159
  540  362  346
   66  713  380
  491  477   44
  411  114  320
  554   96  250
  306   67  196
  769  553  333
  762  436  382
  278  322  153
  894  603  334
  539  441  844
  486  162  927
  197    9  218
   94  221  804
  250  220  913
  557  626  486
  562  705  630
  968  922  285
  518   36  468
   18  608   83
  512  611  530
  534   37   65
  621  136   90
  239  113  139
  371  640  956
  629   54  959
  531  620  338
  682  499  810
  798  170  968
  187  640  645
  660  535  332
  663  530  314
   64   26   65
   55  285  488
  620  288   52
  642  474  450
  455    9  962
   51  760  489
  426  760  833
  304  783  772
  498  765  695
  635   53  126
   44  430  774
  979  943  838
  962  892   64
  494  709  614
    7  695  120
  503  114  606
  362  340  689
  509  367  389
  673  410  664
  773  262  558
  897  958  245
  140  773  483
  965  468  584
  546  209  668
  856  381  184
  274  237  762
  888  677  906
  871  516  405
  102  529  912
  285  724  885
  352  501   53
  774  139  245
  380  309  594
  813  185  765
  530  645  965
  958  618  120
  851  202  957
  737  476  131
  595  546  108
  716  113   66
  327  215  318
  397  343  390
  351  143  103
  138   91   31
  108  224  919
  230  276  896
  426  975  177
  327  975  918
  238  365  764
  328  799  775
  590  906  967
  578  460  338
  507  619  647
  711  617  867
  933  478  734
  820  760  721
  199  711  824
  983  214  228
  382  150  648
  415  782  242
  615  754  445
  693  689  590
  382  784  482
  997  181  322
  682  241  172
  587  302  252
  184  135  254
  574  104  549
   88  738  796
  486  715  861
   62  491  815
  463  434  569
  519  622  310
  199  443  782
  572  657   85
  763  517  844
  750  175  835
  228  269  710
  611  316  551
  883  546  296
  169  693   18
  992  743  316
  263  529  529
  705  570    4
  918  706  527
  609  285  971
  260  533  112
  711  486  904
  820   40  472
  997  301  129
  257  288  343
  635  439  375
  560  381  417
  773  105  145
   58  963  267
  976  742  424
  994  441  384
  389  770  514
  782  463  335
  919  727  276
  780  794  372
  326  180  590
  918  946  257
  889  842  181
  507   61  464
  762  835  443
  827  607  982
  174  875  544
  934  885  589
   32  343  757
  987  826  257
  981  782  844
  446  291  397
  443  800  421
  165  668  539
  410  373  487
  422  803  881
  546  998  953
  291  607  160
  919  894   62
  842  718  117
  110  816  582
  470  836  596
  575  687   35
   37  835  374
   90  954  354
  101  141  407
  174  398  499
  173  737  964
    4  365  950
  946  616  634
  906  904  619
   40  789   16
  788  769   76
  737  867   88
  565  812   31
  508  380  201
   34  935  339
  500  862  326
  431  181  475
  403  346  585
   88  530  708
  731  137  781
  715  563  272
  817  659  932
  396  368  360
  162  683  376
  278  620   39
  525  910  371
  688  524  149
  488  998  279
  286  392  523
  325  144  406
   79  532  419
  540  460  465
  222  832  416
  517  507   46
   87  744  183
  382  819  701
  306  763  647
  744   74  913
   62  813  849
  691  874  775
  291  422  314
  432  630  809
  611  510  566
  583  745  289
  397   19  727
  188  766  442
   96  108  329
  963  719  598
  963  764  469
  444  636  731
  792  636  422
  993    1  416
  518  300  532
  298  312  736
  316  111  463
  825  569   35
  858  591  584
  809   84  607
  681  610  740
  383  279  210
  851  733  615
  287  959  160
  856  851  171
  606  115  211
  310  541  845
  506  119  319
  665  471  562
  382  885  798
  440   29  595
  113  903  475
  257  773  846
  306  741  776
   97  804   76
  489  332  423
  466  632  613
   86  739  481
  199  846  712
   62  282  809
  155  681  142
  705  525  270
  159  800  117
  612  664  316
  505  616  837
  578  839  770
  942  535  122
  542  781  512
  552   22  475
  760  791   97
  432  626  837
   26  616  336
  412  316  702
  108  232  242
  158  311  449
   60  141  325
   58    1  714
  532  977  123
  531  978  598
  679  899   57
  645  523   54
  167  892   14
  164  574  492
  105   37  491
  132  555  485
  600  879  508
  608  843  222
  270  255  398
  232  960  281
  241  995  436
  113  674  411
  381  567    5
  697  450  966
  726  857  969
  722  686  965
  543   20  453
  955  689  554
  858  161  923
  140  979  953
  786  836  237
  200  322  875
  311  623  398
  510  814  945
   67  387  825
  621  620  740
  630  842  163
  545   75  373
  506  531  501
  301  571  357
  746  491  253
   37   29  748
  769  507  754
   69  886  861
  423  629  856
  380  723   83
  875  647  657
  144  696  580
  896   49  629
  275  598  374
  118  636  279
  277   80  529
  623  130  493
  368  712  621
  833  730  512
   59  767  829
  105  933  731
   54  240  108
  803  235  992
  837  726  881
  426  855  450
  636  730  731
  840  561  977
  996  229  670
  508  234  186
  529  108  917
  373  337  795
  681   35  565
  790  251  152
  301  235  599
  875  416  653
  277  338  990
  800  207  595
  954  650  896
  931  667  706
   84  851  822
  254  778  816
  316  141  732
  233  759  239
  546  473  315
   69   15   96
  513  470  320
  460  188  729
  429  950  288
  709  807  790
  456  161  570
  269  718  339
  213  628  602
  155  367  686
  176  418  568
   66  251  723
  959  696  536
  794  279  885
  315  527  993
  603  853  868
  727  747  994
  411  287  193
  528  763  559
  803  149  739
  542  883  696
  275  676  183
  411  317  161
  349  875   35
   39  729  221
  256  831  216
  247  238  176
  399   59  306
  409  445  550
    9  387  253
  613  204  474
   81  868  944
  589  912  735
  319  264   83
  984  704  614
  778  614  532
  699  762  556
  680  250  507
  504  581  647
  160  351  295
  513  739  413
  651  915  651
  878  218  499
  872  990  503
   38  886   12
  218  201  415
  240  250  504
  265  448  382
  402  876  126
  488  950  649
  189  210  597
   24  850  758
   30  451  347
    5  437  723
  634  310  546
  801  179  411
  679  338  852
  385   32  933
  406  531  554
   88  516  871
  860  486  834
  467  535  849
  419  820  785
  206  649  526
  244  499  714
   80  774  678
  336  149  612
  310  175  656
  150  221  791
  159  806  701
  336  465  530
  376  819  272
  533  472  421
   82  124  909
  523  561  539
  844  811  576
  439  612  587
  782  457  686
  152   51  837
  413  573  855
  403  608   26
  893  819  910
  361  499  657
  677  937  617
  428    6  343
  310   38  431
  474   35  420
  574  256  221
  700  907  515
  149  685  478
  206  325  720
  114   51   67
  320  338  686
  293   59  527
  147  756  986
  250  697  573
  968  194  545
  542  480   72
  454  574  619
  473   55  592
  475  339  889
  884  313  993
  125  127  742
  591  514  585
  543  583  282
  264  580  390
  839  487  781
  902  664  868
  334  459  819
  107   20  211
  368  479  775
  683  691  273
  681  336  630
   22  978  536
  926  828  708
  210  319  723
  787  689  866
  854  633  856
  960  494  866
  122  687  596
  918  705  539
   84  564  791
  876  138  949
  836    1  500
  718  308  466
  228  311  271
  421  998  433
  622  772  174
  875  720  432
  680  687  509
  215   95  623
  674  732  166
  198  174  645
  721  839  390
  617  896  448
   73  331  155
  789  134  431
  853  376  400
   82  862  411
  779  362   70
  750  777  349
  674  604  224
  812  731  446
  280  546  336
  922  781  619
  196  892  876
  941  361  479
  344  988  873
  499   92  795
  287  913  546
  625  167  604
  617    1  399
  154  166  720
  328  323  111
  713  619  530
  606  756  580
  194  247  935
  149   65   64
   55  287  902
  870  866  127
  478  679  587
  900  459  565
  563  787  743
  962  798  769
  669   39  525
  745  691  317
  484  123   93
  500  598  348
  159  535  681
  618  176  877
  723  373  464
  304  184  131
  542  209  654
  716   47  647
  976  537  771
  914  606  568
  241  250  481
  616  640  660
  744  187  843
  303  617  927
  369  525  773
  754  697  360
  595  560  605
  562  589  610
  799  497  655
  823  553  532
  937  502  449
  976  941  158
  194  720  347
  474  694  822
  528  184  272
  922  698  568
  415  889  638
  169  822   65
  547  281  663
  582  167  110
  365   56  914
  431  162  923
  473  812  578
  572  890  386
  164  119  308
  604  946  496
  327  142   72
  641  916  472
  743  663  228
  107  446  345
  823  486  152
  997   47  968
  565  155  631
  438  205  416
  271  163  875
  123  393  111
  169  412  854
  615  683  659
  592  362    9
   99  895  668
  834  205  172
  359  355  550
  499  149  389
  755  298  916
  475  706  807
  829  425  118
   43  527  479
  159  473  874
  151  326  992
  970  660  509
  837  930   35
  164  345  506
  209  879  487
   97  157  503
  289  755  793
  624  897  293
  382  134  451
  257  917  339
  110  168   85
  470  583  139
  486  613  120
  584  747  795
  959  699  339
  866  384  672
  157  639  464
  939  485  409
  947  441  131
  179  953  581
  735  587  605
  834  582   36
  304  422  707
  195  348  347
  163  521  486
  948  471  675
  915  453  406
   40  345  635
   81  124  115
  127  105  127
   50   32   10
  221  399  397
  487  676  412
  574  607  450
  268  625  323
  843  858  145
  706  286  218
  822  168  254
  950  708  944
  572  640  775
  958  563  909
  996  154  918
  378  626  564
  335  823  339
  499  810  270
  294   22   98
  987  959  591
  101  899  442
  931  409  576
  542  102  655
  404  980  398
  759  990  381
  692  990  750
  752   93  149
  278  973  883
  621  459  232
  398  261  626
  221  212  744
  790  241  352
  802  218  317
  443  294  244
  393  131  941
  466  378  885
  516  419  240
  799  748  407
  468  502  386
  829  329  766
  432  376  408
  681   88  198
  553  351  489
  234  717   59
  332  525  675
  437  691  723
  441  834  433
  616  144  274
  966  911  650
  254  274  782
  346  714  856
  330  696  171
  394  407  298
  897  553  867
  755  503  956
  253  840  382
  923  195  262
  918  735  483
   55  703  227
  768  759  225
  825  238   14
    7  479  978
  211  603  957
  216  866   94
  112  698   60
  847  631  307
  940  164  253
  406  133   14
  380  816  425
  147  873  429
  698  987   98
  534  823  691
  197  690  754
  979   39  468
  928   73  531
  119   66  920
  982  810  569
  476  534  397
  931  366  182
  783  104  732
  131   32  619
  784  136  530
   16  933  484
  995  987  739
  985   88  977
   43  919  914
  540  399  915
  566  859  257
  639  419   73
  727  118  865
  477  370  834
  293  434  155
  422  557  603
  203  243  754
  373   15  748
  466  574  807
  282  576   70
  275  365  608
  987  644  648
  711  629  717
  420  410  696
  252  417  874
  642   26  202
  223   23  531
  545  580  675
  565  600  521
  130  745  142
  264  377  397
  300  618  253
  683  331  279
  440  826  275
  835  785  266
  592  264  590
  257  255  173
  532   23  620
  571  749  434
  988  552  492
  566  766  234
  617  818  776
   45  113  882
  579  793  114
  971  243  608
  979  241  241
  130   83  634
   91  361    5
  311  107  501
  377  388  496
  727  849  317
  323  702  256
  804  254  189
   70   11  246
  752  425  785
  799  413  882
  917  133  695
  959   49  902
  420  121  412
  177  170  158
  828  734  135
  880  875   75
  824  556  960
  857  689  960
   74  951    2
  246  687  756
  311   93  487
  209  626  886
   17  545  566
  963  252  283
  947  493  805
  185  493  462
  728  365  885
  808  214  528
  582  780  100
   30  254  654
  596  706  553
  713  968  803
  123  270  839
  792  778  475
  442   95  682
  931  212  678
  781  140  439
  651  645  978
  137  829  286
  593  503  895
  642  215  144
  687  122  934
   84  240  919
  656  515  774
   51  799  273
  636  324  924
  213  161  309
  509  157  458
  582    1  727
  716  269  819
  978  343  303
  828  264  708
  108  620  190
   12   12  634
  103  615  579
  364  286  660
  809  714  656
  729  504   10
  994  366  341
  433  796   77
  663  462  353
  776  687  758
  751  495  651
   33  751  753
  349  919  228
  204  799  584
  335  156  563
  725  191  535
  731  676  524
  455  571   10
  899  379  689
  773  641  812
  324  761  421
  354  557  897
  571  740  161
  407  271  856
  886  393  428
  286  870  218
  950  819  347
  331  847  858
  498  471  689
  357  378  775
  890  503  514
  201  863  428
  721  737  796
  636  178  974
   14  387  936
  622  424  144
   82  201  727
  127  164  779
  173  319  326
  195  748  641
  469  512  510
  626  949  405
  552  542  251
  192  204  382
  655  558  631
  970  519    3
  918  701  399
   56  543  403
  524  848  641
  620  431  539
  604  473  824
  369  105  464
  575  957  429
  859  978  199
  712  381  199
  941  305  738
  892  663  937
  653  963  365
   70  331  508
  620  923  682
  739  122  350
  288  418  768
  733  326  520
  694  472  793
  725  415  739
  895  398  201
  500  157  168
  727  814  354
  807  726  340
  431  329  212
  635  374  403
  677   78  347
  386  559  505
  385  361  161
  262  494  621
  481  237  767
  318  966  640
  723  732  546
  911  652  823
  958  502  677
  718  258  834
   98  666  506
  929   41  933
  869  637  605
  585  156  335
  490  316  149
  436  339  323
  596  948  224
  275  433  241
  545  890  155
  601  413  676
  893  401  673
  694  171  403
  211  110  482
  267   61  541
  206  124  256
  189  353  308
  351  880   70
  237  677  380
  759  754  388
  465   99  862
  852  787  925
  758  890  804
  252  817  784
  773  129  860
  954  102  872
  743  396  730
  500  304  173
  492  399  527
  413  465  813
  670  837  933
  897  424  430
  782  404   14
  151   24  418
  897  260  306
  811  287  386
  440   93  449
  229  185  582
  136   63  678
  211  250  940
  184  400  209
  122  383  238
  143  386  111
  320  194  415
  925  790  501
  924  596  614
  606  733  277
  886  116  194
  278  627  189
  225  536  981
  487  538  584
  539    2  793
  219  456   57
  341  424  941
  199  482  921
  231  241  588
  711  740  334
  596  554  323
  917  164  629
   19  138  756
  939   70  225
  536  432  401
  137  614   14
  593  818  402
  871  280  515
  268  259  326
  900   97  376
   68  699  461
  546  810  400
  540  697  676
  591  125  751
  159  719  919
  605  763  898
  171  845  459
  115  289  376
  265  636  317
  646  225   84
  663  755   89
  192  828   12
  316  523  822
  310  933  784
   44  721  873
  893  873  461
  898   15  548
   96  861  726
    9  837  398
  238  404   29
  227  845  428
  770  764  472
  960  747  784
  990  281  811
   59  597  111
  930  799  729
  930  882  758
  459  961  116
  484   83  914
   83  969  994
  828  423  132
  346  541  246
  783  484  303
  983    7  921
  216  208  905
  802  216   54
    6  121  306
  609   36  749
  608   84  626
   97  705   89
  200  688  878
  242  314  802
  294   66  338
  768  417  272
  785  351  266
   58  505  668
  791  291  679
  783  694   43
  794  468  355
  777  796  171
  378  784  426
  224  510  840
  557  606  708
  513  127  189
  231  976  517
  772   37  433
  684  973  324
   70  661   83
  914  136  702
  917  630  710
  826  894   84
  373  416  248
  551  924  226
  357  646  374
  890  491  246
  938  293  519
   66   42  704
  537   60  374
  508   56  405
  437  751  653
  681  718  160
  683  293  800
  569  288  878
  692  206  611
  173  157  399
  201  492  645
   98  132  329
  234  612  711
  296   54  975
  651  219  923
  527  177  138
  585  598  302
  552  653  474
   54  288  358
  828  631  279
  854  642  746
   80   52  645
  386  346  181
  488    7  569
  168  351  533
  906  186  681
  833  404  191
  863  297  526
  451  555  808
  336  544  155
  253  211  838
  759  819  238
  921  343  761
  264  632  690
  165  424  159
  121  481  361
  181  409  439
   94  972  995
  696  904  722
  613  238  422
  190  281  334
  385  127  129
  300  364  234
  479  768  937
  883  654   35
  979  679  959
  244   51  788
  275  613  804
  143  575  210
  160  168  608
  330  471  651
  407  594  410
  723  576  943
  268  912  361
  692  442  760
  443  288   20
  382  610  556
   62  694  568
  322  257  214
  253  458  861
  260  213  829
   37  137  420
  668  220  104
  673  150  435
  551  466  897
  390  729  999
  423  963  763
  837   36  295
  854  726  495
   16  728  389
  735  246  510
  218  136  617
  604  197  140
  113  355  499
  631  902  488
  689  898  212
  780  826  901
  556  205  657
  855  661  288
  141   34  480
   27   23  194
  115   53  393
  333  287  700
   68  300  671
  394  589   28
  572  248  771
  454  118  797
  526  141  300
  785  377  504
  886  723  105
  541  712  470
  156  128  932
  479   85  989
  381  207  162
  813  839  544
  143  783  541
  916  361   24
  878  133  886
  986  750  335
  122  643  864
  395  460  591
  387  896  627
  117  455  109
    2   14  569
  873  364  215
  875  350  554
   70  878  940
  234  846   82
  256  279  901
  693  990  473
  951  866  824
  923  408  891
   36    5  531
  954  654  266
  921  652  434
  561  701  427
  232  764  365
  330  331   73
   46  813    6
  380  698  297
  396  221  289
  135  867  633
  814  649  286
  797  918  827
  705   58  338
    6  305  310
  701  352   28
  903   97  825
  693  126  794
  438  144  592
  367  932  400
  320  820  264
  687  210  652
  682   84  566
  671  604  816
  529  646  267
  795  654  114
  955  426  118
  249  759  102
  343  581  267
  341  619  107
  479   57  341
  683   32  870
  630  609  210
  361  643  803
  506  856  406
  580  562  359
  312  433  154
  750  379  920
  448  520  312
  733  259  899
   33  786  319
  579  669   90
  595  769  242
  160  985  236
  654  903  946
  635   99  802
   75  158  437
  467  382  289
  406  542  548
  684  417  794
  729  105  122
   44  485  689
  737   15  713
  970  391   17
  373  384  729
  336    1  118
  814  807  759
  965  808  828
  179  181  834
  242   94  838
  188  183   82
  691  402  618
  984   43  561
  330  447  872
  553  581   30
  884  393  836
  431  298  837
  278  389  690
  976  587  803
  722  220  538
  548  208  107
  629  414  729
  543  584  672
  512  431  954
  475  367  959
  226  306    9
  824  774  668
  188   22  870
  722  764  300
  647  803  256
  410  972   21
  436  536  278
  995  577  453
  670  439  224
  434  488  572
   82  317  498
  559  823  662
  499  614  196
  944   14  432
  618  866  652
  467  872  289
  471  722  189
  923  756   17
  790  409  195
  511  500  545
  667  283  758
  271  373  283
  573  686  490
  659  706  560
  770  247  633
  424  169  895
   47  349  411
  380  235  805
  384  546  148
  747  870  831
  754  421  910
  937   15  433
  188  760  806
  872  748  418
  718  556  510
  165  590  486
  798   40  177
  349  923  530
  795  690  746
  550  671  360
  824  442  775
  331  686  152
  570  270  926
  860   64  383
  408  464  170
  758  440  349
  773  434  699
  780  563  352
   18  644  621
  432  663  188
  420  887  956
  237  586  788
  319  526  586
  544  647  115
  628  235  511
  666  408   33
  670  459  697
   48  189  692
  837  708  428
  462  652  632
  426  106  457
  730  744  195
  700  816  769
  383  480  923
  601  612  910
  559  953  779
  533  937  240
  464  123  344
  579   82   76
  179  188  373
    1  641   56
  688  698   50
  688  160    4
  790  364  767
  202   70  137
  914  420  674
  961  657  851
  578  708  875
  503   94  776
  221  143  356
   34  126  403
  234   31   78
  721  949  330
  675  191  460
   80  957  651
  690  580  824
  461   73  802
  725  606   51
  183  857  521
  708  800  482
  644  111   37
  769  778  869
  883  693  909
  549  714   43
  273  246  599
  637  309  675
  451  195  552
  681  408  126
  422  465   52
  743  235  144
  248  586  312
   42  398  313
  222  335   21
  528  312  738
  856  312  132
  915   79  610
  550  605  186
  566  815  698
  127  250  717
  532  129  775
  604  132  549
  134   44  247
  521  815  470
  370  853  515
  795  187  851
  963  295   50
  757  228  169
  706  303  120
  416  133  309
  956   63   11
  751  162  301
  387  632   29
  257  383  994
  215  247  994
  529  606  963
  770  305  756
  721  791  971
  558  531  675
  253  477  918
  470   52  615
  256  335   24
  301  523  651
  316  702  637
  321  721   32
  591  730  179
  341  364  146
  673  120  501
   31  183  207
  641  116  463
  221   54  775
  262  458  669
  139  486  904
  736  260  139
  406  359  663
  434  563  753
  981    6  215
  423  320  358
  719  319  415
  315  375  320
    7  637  423
  314  365  175
  199  687  754
  174  546    1
   29  526  754
  153  402  251
  787  565  919
  820  239  876
  994  614   47
  958  816  288
  244  750  275
  248  890  694
  628  194  414
  774  958  466
  181   34  442
  569  371  939
  500  347  740
  745  123  467
  614  662  119
  201  690  352
  596  974  215
  508  921  240
  405  947  317
  402  372  733
  298   41  357
  135  339  759
  544  683  690
  584    1  893
  215  680  501
  191  453  649
  952   84  727
  815  494  293
  163  168   46
  136  119  441
  185  112  474
  877  830  354
  497  242  226
  484  714  178
  854  570  402
  873  120  432
   30  613   50
  365  529  624
  969  332  586
  636  617  153
  588  669  314
   12   52  628
  584  704  642
   95  199   69
  979  486  705
  953  391  698
  698  471  333
  302  466   64
  678   19  376
  353  860  905
  236  113  797
  400  879  962
  341  805  493
  661  506  196
  736  357  644
  943  352  365
  484  756  282
  491  943  262
  765  494  729
  321  208  986
  621  346  290
  258  706  386
  179  452  276
  433  583  153
  708    2  212
  193  151  320
  647  149  299
  335  951  831
  661  787  792
  818  742  477
  799  964  157
  726  780  172
  740  225   24
  428   39  263
  388  901  506
   97  940  413
   41  454  826
  324  453  443
  346   76  938
  463  595  751
  854  948  454
  451  902  507
  722  961  130
  695  529  425
   59  591  467
  559  623  222
  991  194  196
  749  793  245
  474  327  247
  346    2  277
  643  328  135
  785  264  751
   35  537  887
  811  584  685
  475  903  748
  471  115  698
    7  945  449
  464  880  227
  287  868  878
  564   11  850
  221  623  475
  314  325  553
  209  865  621
   39  655  236
   95  296  235
  124  920   21
  439  473  902
  334  375  792
  315  116  768
  267  736   95
  703  606  595
  505  886  514
  114  168   52
  301  584  495
  200  709  527
  164  422  554
  246  546  460
  377  141  223
  286  323  354
  810  240   90
  920  450  425
  277    8  570
   28  649   50
  295  650  534
  690  187  665
  674  184  483
   68  139  376
  570  430  500
  590  422  543
  304   68   43
  422  666  163
  501  375  696
   81  621  813
   19  981  945
  410   83  941
  427  945   25
  283  408  825
  281  648  635
  294  678  615
  113  936  500
  554  772  314
  502  642  624
  262  318  699
   88  526  817
  242  468  161
  820  179  253
  580   62  531
  343  183  422
  430  161  485
   26  127  435
  442   32  517
  491  243  544
  552  680  310
  131  489  457
  697  162  526
  897  838  305
  695  748  335
  753  936   24
   46  681  637
  745  808  617
  318  251  171
   49   39  855
  359  284  725
  221  837  145
  581  821  444
  573  267  318
  706  969  583
  722  912  586
  680   86  869
  833  546   97
  865  507  481
  938  104  386
  941  217  265
  360   53  607
  634  197  476
  787  659  444
  368  163  783
  493  738  345
  182  539   52
  764  827  612
  699  493  663
  914  384   17
  495  546  260
  739  461  275
  386   91  394
  804  506  198
  780  421  269
  109  669  193
  457  298  349
  560  800  331
  282  153  637
  160  254  807
  434  204  476
  717  759  737
  629  785   65
  347  614  790
  270  663  647
  188  271  528
  277  929  591
  853  744  589
  704  881  761
  573  714  627
  541  689  287
  540  301  187
  670  397  368
  867    8  698
  869  146  802
   10  137  104
  164  575  450
  507  233  466
  548  425   46
  435  824   78
  334  951   34
  646  551   99
   60  829  569
  501  866  382
  440  327  222
  744  132  333
  800  983  126
  887  866  451
   28  599   39
  833  129  307
  804  519  319
  510  746  821
  639  209  561
  197  649  333
  638  644  361
  754  474  366
  193  219  106
  843  536  331
  483  634  611
  367  195  592
  753   71  115
  934   42   83
  337   75   85
  475  304  169
  672  143  211
  360  406   74
  370  119  111
  351  955  696
  543  849  785
  375  576  836
  288  316  239
  512  273  786
  721  407   82
  998  634  292
  449  399  284
  540  316  693
  430   68  984
  146  376  482
  785  134  643
  157  509  441
  808  615  552
  920  564  452
  407  341  441
  990  778  211
  822  325  925
  368  206  876
  491  153  126
   11  373  546
  854  752  143
  843  773  660
  777  472  964
  359  708  889
  575  941  882
  945   22  152
  968  237  115
   30  238  110
  101  504  412
  119  646  719
   28  190  336
  890  301  712
   11  657  782
  885  465  361
  424  669  645
  528  654  194
  894  252  667
  516  299  998
  370  837  976
  305  651  194
  701  447  175
  470  234  929
  752  606  965
  568  370  322
  226  592  281
  553  801  330
  576  228  623
  639  477  637
  252  664  998
  781  215  994
  446  698   25
  562  500  980
  702  444  299
  971  550  387
  754  562  439
  347  896  716
  242  861  596
  588  829  323
  464  211  949
  481  192   47
  598   98  963
  932  960   32
  933  482  893
   15  989  888
  866  735  629
  636  513  470
  280  528  944
  531   66  867
  284  735  865
  778  743    3
  458  131  262
  772  273  255
  942  278   50
  269  151  917
  502    4  883
  538  155   68
  929  850   21
  126  759  729
  869  689  711
  180  359  855
  299   68  975
  210  371  205
  477  183  827
  922   50  841
  665  154  312
  379  848  486
  450  835  743
   69  161  515
  680  535   83
  692  779  352
  818  554  389
  781   89  538
  746  218  209
  292  201  652
  417  375  393
  916  962  644
  518  923  561
  915  469  386
  142  460  454
  947  392   89
  144  840  866
  205  465  967
  209  657  650
  891  322  207
  800  522  907
  516  498  994
  185  806  804
  179  393  137
  316  765  892
  850  756  123
  494  783  627
  832   53  659
   93  949  602
  666  954  516
  592   11  210
  223    4  389
  221  280  388
  100  279   50
  380  589  345
  385  238  382
  205  506  359
   98  280  652
  396  371  290
  314  477  454
  368  692  564
   48  263  586
  356  902  922"""
    // Part 1 How many of the input triangles are legal? 
    // The two smaller sides must sum to equal or larger than the longest side
    print(getNumberOfLegalTriangles(input))
  }

  def getNumberOfLegalTriangles(input: String): Int = {
    var countOfLegalTriangles = 0
    for (triangle <- input.split("\n")) {
      println(triangle)
      var t = triangle.split(" ").filterNot(_ == "").map(_.toInt).sortWith(_ < _)

      if (t(0) + t(1) > t(2)) {
        countOfLegalTriangles += 1
      }
    }

    countOfLegalTriangles
  }

}
