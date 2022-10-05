---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/TemplateDualSegmentTree_test.java
    title: library/TemplateDualSegmentTree_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.function.*;\nimport library.SimpleUtil;\n\
    \nclass TemplateDualSegmentTree<T> {\n\t@FunctionalInterface\n\tinterface BinaryConsumer<T>\
    \ extends BiConsumer<T, T> {  }\n\n\tSupplier<T> e2Supplier;\n\tT e2;\n\tBinaryConsumer<T>\
    \ g;\n\n\tint n;\n\tint height;\n\tT lazy[];\n\tint rangeL[];\n\tint rangeR[];\n\
    \n\t// O(N)\n\tTemplateDualSegmentTree(T[] a, Supplier<T> e2Supplier, BinaryConsumer<T>\
    \ g) {\n\t\tthis(a.length, e2Supplier, g);\n\t\tSystem.arraycopy(a, 0, lazy, n,\
    \ a.length);\n\t}\n\tTemplateDualSegmentTree(int len, Supplier<T> xSupplier, Supplier<T>\
    \ e2Supplier, BinaryConsumer<T> g) {\n\t\tthis(len, e2Supplier, g);\n\t\tfor(int\
    \ i = 0; i < len; i ++) lazy[i + n] = xSupplier.get();\n\t}\n\t@SuppressWarnings(\"\
    unchecked\")\n\tTemplateDualSegmentTree(int len, Supplier<T> e2Supplier, BinaryConsumer<T>\
    \ g) {\n\t\tSimpleUtil.nonNegativeCheck(len);\n\t\tthis.e2Supplier = e2Supplier;\n\
    \t\tthis.e2 = e2Supplier.get();\n\t\tthis.g = g;\n\t\tn = 1;\n\t\theight = 0;\n\
    \t\twhile(n < len) { n <<= 1; height ++; }\n\t\tlazy = (T[]) new Object[n << 1];\n\
    \t\tfor(int i = 0; i < lazy.length; i ++) lazy[i] = e2Supplier.get();\n\t\trangeL\
    \ = new int[n << 1];\n\t\trangeR = new int[n << 1];\n\t\tfor(int i = 0; i < n;\
    \ i ++) { rangeL[i + n] = i; rangeR[i + n] = i + 1; }\n\t\tfor(int i = n - 1;\
    \ i > 0; i --) { rangeL[i] = rangeL[i << 1]; rangeR[i] = rangeR[(i << 1) + 1];\
    \ }\n\t}\n\n\tvoid eval(int k) { // O(1)\n\t\tif(!lazy[k].equals(e2)) {\n\t\t\t\
    if(k < n) {\n\t\t\t\tg.accept(lazy[k << 1], lazy[k]);\n\t\t\t\tg.accept(lazy[(k\
    \ << 1) + 1], lazy[k]);\n\t\t\t\tlazy[k] = e2Supplier.get();\n\t\t\t}\n\t\t}\n\
    \t}\n\n\tvoid update(int l, int r, T val) { // O(logN)\n\t\tSimpleUtil.inclusiveRangeCheck(l,\
    \ n);\n\t\tSimpleUtil.inclusiveRangeCheck(r, n);\n\t\tSimpleUtil.assertion(l <=\
    \ r, \"l is larger than r.\");\n\t\tl += n; r += n - 1;\n\t\tfor(int i = height;\
    \ i > 0; i --) { eval(l >> i); eval(r >> i); }\n\t\tr ++;\n\t\twhile(l < r) {\n\
    \t\t\tif((l & 1) != 0) { g.accept(lazy[l], val); eval(l); l ++; }\n\t\t\tif((r\
    \ & 1) != 0) { r --; g.accept(lazy[r], val); eval(r); }\n\t\t\tl >>= 1; r >>=\
    \ 1;\n\t\t}\n\t}\n\n\tT get(int j) { // O(logN)\n\t\tSimpleUtil.inclusiveRangeCheck(j,\
    \ n);\n\t\tj += n;\n\t\tfor(int i = height; i > 0; i --) eval(j >> i);\n\t\treturn\
    \ lazy[j];\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/TemplateDualSegmentTree.java
  requiredBy: []
  timestamp: '2022-10-05 15:32:30+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/TemplateDualSegmentTree_test.java
documentation_of: library/TemplateDualSegmentTree.java
layout: document
redirect_from:
- /library/library/TemplateDualSegmentTree.java
- /library/library/TemplateDualSegmentTree.java.html
title: library/TemplateDualSegmentTree.java
---
