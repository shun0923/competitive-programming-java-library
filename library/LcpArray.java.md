---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  - icon: ':heavy_check_mark:'
    path: library/SuffixArray.java
    title: library/SuffixArray.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/LcpArray_test.java
    title: library/LcpArray_test.java
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
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.SuffixArray;\n\nfinal class LcpArray {\n\t// O(|S|)\n\tpublic static\
    \ final int[] cal(String s) { return cal(s, SuffixArray.cal(s)); }\n\tpublic static\
    \ final int[] cal(char[] c) { return cal(c, SuffixArray.cal(c)); }\n\tpublic static\
    \ final int[] cal(int[] a) { return cal(a, SuffixArray.cal(a)); }\n\tpublic static\
    \ final int[] cal(String s, int[] sa) { return cal(s.toCharArray(), sa); }\n\t\
    public static final int[] cal(char[] c, int[] sa) { return cal(SimpleUtil.charToInt(c),\
    \ sa); }\n\tpublic static final int[] cal(int[] a, int[] sa) {\n\t\tint n = a.length;\n\
    \t\tint rnk[] = new int[n];\n\t\tfor(int i = 0; i < n; i ++) rnk[sa[i]] = i;\n\
    \t\tint[] lcp = new int[n - 1];\n\t\tint h = 0;\n\t\tfor(int i = 0; i < n; i ++)\
    \ {\n\t\t\tif(h > 0) h --;\n\t\t\tif(rnk[i] == 0) continue;\n\t\t\tint j = sa[rnk[i]\
    \ - 1];\n\t\t\tfor(; j + h < n && i + h < n; h ++) {\n\t\t\t\tif(a[j + h] != a[i\
    \ + h]) break;\n\t\t\t}\n\t\t\tlcp[rnk[i] - 1] = h;\n\t\t}\n\t\treturn lcp;\n\t\
    }\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/SuffixArray.java
  isVerificationFile: false
  path: library/LcpArray.java
  requiredBy: []
  timestamp: '2022-10-05 21:11:17+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/LcpArray_test.java
documentation_of: library/LcpArray.java
layout: document
redirect_from:
- /library/library/LcpArray.java
- /library/library/LcpArray.java.html
title: library/LcpArray.java
---
