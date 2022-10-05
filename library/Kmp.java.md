---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: library/Kmp_test.java
    title: library/Kmp_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
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
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\n\nfinal\
    \ class Kmp {\n\t// O(|S|)\n\tpublic final int a[];\n\tpublic final int kmp[];\n\
    \tpublic Kmp(String s) { this(s.toCharArray()); }\n\tpublic Kmp(char[] c) { this(SimpleUtil.charToInt(c));\
    \ }\n\tpublic Kmp(int[] a) {\n\t\tthis.a = a;\n\t\tkmp = new int[a.length + 1];\n\
    \t\tkmp[0] = -1;\n\t\tint r = -1;\n\t\tfor(int l = 0; l < a.length; l ++) {\n\t\
    \t\twhile(r != -1 && a[l] != a[r]) r = kmp[r];\n\t\t\tr ++;\n\t\t\tif(l + 1 <\
    \ a.length && a[l + 1] == a[r]) kmp[l + 1] = kmp[r];\n\t\t\telse kmp[l + 1] =\
    \ r;\n\t\t}\n\n\t}\n\n\t// return all the occurrences of S in T\n\t// O(|S|+|T|)\n\
    \tpublic final int[] match(String t) { return match(t.toCharArray()); }\n\tpublic\
    \ final int[] match(char[] c) { return match(SimpleUtil.charToInt(c)); }\n\tpublic\
    \ final int[] match(int[] b) {\n\t\tArrayList<Integer> match = new ArrayList<Integer>();\n\
    \t\tint j = 0;\n\t\tfor(int i = 0; i != b.length; ) {\n\t\t\twhile(i != b.length\
    \ && j != a.length && b[i] == a[j]) { i ++; j ++; }\n\t\t\tif(j == a.length) match.add(i\
    \ - j);\n\t\t\tj = kmp[j];\n\t\t\tif(j == -1) { i ++; j ++; }\n\t\t}\n\t\tint\
    \ matchList[] = new int[match.size()];\n\t\tfor(int i = 0; i < match.size(); i\
    \ ++) matchList[i] = match.get(i);\n\t\treturn matchList;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/Kmp.java
  requiredBy: []
  timestamp: '2022-10-05 20:31:46+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - library/Kmp_test.java
documentation_of: library/Kmp.java
layout: document
redirect_from:
- /library/library/Kmp.java
- /library/library/Kmp.java.html
title: library/Kmp.java
---
