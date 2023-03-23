---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/FastIO.java
    title: library/FastIO.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: library/ZAlgorithm_test.java
    title: library/ZAlgorithm_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 466, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 571, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport library.FastIO;\n\nfinal class ZAlgorithm {\n\t\
    // return the length of the longest list starting from S[i] which is also a prefix\
    \ of S\n\t// O(|S|)\n\tpublic static final int[] cal(String s) { return cal(s.toCharArray());\
    \ }\n\tpublic static final int[] cal(char[] c) { return cal(FastIO.charToInt(c));\
    \ }\n\tpublic static final int[] cal(int[] a) {\n\t\tint len = a.length;\n\t\t\
    int match[] = new int[len];\n\t\tmatch[0] = len;\n\t\tint i = 1;\n\t\tint j =\
    \ 0;\n\t\twhile(i < len) {\n\t\t\twhile(i + j < len && a[j] == a[i + j]) j ++;\n\
    \t\t\tmatch[i] = j;\n\t\t\tif(j == 0) { i ++; continue; }\n\t\t\tint k = 1;\n\t\
    \t\twhile(i + k < len && k + match[k] < j) { match[i + k] = match[k]; k ++; }\n\
    \t\t\ti += k;\n\t\t\tj -= k;\n\t\t}\n\t\treturn match;\n\t}\n}"
  dependsOn:
  - library/FastIO.java
  isVerificationFile: false
  path: library/ZAlgorithm.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - library/ZAlgorithm_test.java
documentation_of: library/ZAlgorithm.java
layout: document
redirect_from:
- /library/library/ZAlgorithm.java
- /library/library/ZAlgorithm.java.html
title: library/ZAlgorithm.java
---
