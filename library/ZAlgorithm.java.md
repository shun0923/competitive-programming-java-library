---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/ZAlgorithm_test.java
    title: library/ZAlgorithm_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 421, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 526, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport library.SimpleUtil;\n\nfinal class ZAlgorithm\
    \ {\n\t// return the length of the longest list starting from S[i] which is also\
    \ a prefix of S\n\t// O(|S|)\n\tpublic static final int[] cal(String s) { return\
    \ cal(s.toCharArray()); }\n\tpublic static final int[] cal(char[] c) { return\
    \ cal(SimpleUtil.charToInt(c)); }\n\tpublic static final int[] cal(int[] a) {\n\
    \t\tint len = a.length;\n\t\tint match[] = new int[len];\n\t\tmatch[0] = len;\n\
    \t\tint i = 1;\n\t\tint j = 0;\n\t\twhile(i < len) {\n\t\t\twhile(i + j < len\
    \ && a[j] == a[i + j]) j ++;\n\t\t\tmatch[i] = j;\n\t\t\tif(j == 0) { i ++; continue;\
    \ }\n\t\t\tint k = 1;\n\t\t\twhile(i + k < len && k + match[k] < j) { match[i\
    \ + k] = match[k]; k ++; }\n\t\t\ti += k;\n\t\t\tj -= k;\n\t\t}\n\t\treturn match;\n\
    \t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/ZAlgorithm.java
  requiredBy: []
  timestamp: '2022-10-05 21:11:17+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/ZAlgorithm_test.java
documentation_of: library/ZAlgorithm.java
layout: document
redirect_from:
- /library/library/ZAlgorithm.java
- /library/library/ZAlgorithm.java.html
title: library/ZAlgorithm.java
---
