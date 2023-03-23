---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/FastIO.java
    title: library/FastIO.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/DynamicSwag_test.java
    title: library/DynamicSwag_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
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
  code: "package library;\n\nimport java.util.*;\nimport java.util.function.*;\nimport\
    \ library.FastIO;\n\nclass DynamicSwag {\n\tlong e;\n\tLongBinaryOperator f;\n\
    \n\tDeque<Long> frontVal = new ArrayDeque<>();\n\tlong front;\n\tDeque<Long> back\
    \ = new ArrayDeque<>();\n\n\t// O(1)\n\tDynamicSwag(long e, LongBinaryOperator\
    \ f) {\n\t\tthis.e = e;\n\t\tthis.f = f;\n\t\tfront = e;\n\t}\n\n\t// O(1)\n\t\
    long fold() { return back.isEmpty() ? front : f.applyAsLong(back.getLast(), front);\
    \ }\n\t// O(1)\n\tvoid push(long x) {\n\t\tfrontVal.addLast(x);\n\t\tfront = f.applyAsLong(front,\
    \ x);\n\t}\n\t// O(1) amortized\n\tvoid pop() {\n\t\tif(back.isEmpty()) {\n\t\t\
    \tlong tmp = e;\n\t\t\twhile(!frontVal.isEmpty()) {\n\t\t\t\ttmp = f.applyAsLong(frontVal.removeLast(),\
    \ tmp);\n\t\t\t\tback.addLast(tmp);\n\t\t\t}\n\t\t\tfront = e;\n\t\t}\n\t\tback.removeLast();\n\
    \t}\n}"
  dependsOn:
  - library/FastIO.java
  isVerificationFile: false
  path: library/DynamicSwag.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/DynamicSwag_test.java
documentation_of: library/DynamicSwag.java
layout: document
redirect_from:
- /library/library/DynamicSwag.java
- /library/library/DynamicSwag.java.html
title: library/DynamicSwag.java
---
