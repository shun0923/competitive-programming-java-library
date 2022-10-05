---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/TemplateDynamicSwag_test.java
    title: library/TemplateDynamicSwag_test.java
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
  code: "package library;\n\nimport java.util.*;\nimport java.util.function.*;\nimport\
    \ library.SimpleUtil;\n\nclass TemplateDynamicSwag<T> {\n\tSupplier<T> eSupplier;\n\
    \tBinaryOperator<T> f;\n\n\tDeque<T> frontVal = new ArrayDeque<>();\n\tT front;\n\
    \tDeque<T> back = new ArrayDeque<>();\n\n\t// O(1)\n\tTemplateDynamicSwag(Supplier<T>\
    \ eSupplier, BinaryOperator<T> f) {\n\t\tthis.eSupplier = eSupplier;\n\t\tthis.f\
    \ = f;\n\t\tfront = eSupplier.get();\n\t}\n\n\t// O(1)\n\tT fold() { return back.isEmpty()\
    \ ? front : f.apply(back.getLast(), front); }\n\t// O(1)\n\tvoid push(T x) {\n\
    \t\tfrontVal.addLast(x);\n\t\tfront = f.apply(front, x);\n\t}\n\t// O(1) amortized\n\
    \tvoid pop() {\n\t\tif(back.isEmpty()) {\n\t\t\tT tmp = eSupplier.get();\n\t\t\
    \twhile(!frontVal.isEmpty()) {\n\t\t\t\ttmp = f.apply(frontVal.removeLast(), tmp);\n\
    \t\t\t\tback.addLast(tmp);\n\t\t\t}\n\t\t\tfront = eSupplier.get();\n\t\t}\n\t\
    \tback.removeLast();\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/TemplateDynamicSwag.java
  requiredBy: []
  timestamp: '2022-10-05 21:11:17+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/TemplateDynamicSwag_test.java
documentation_of: library/TemplateDynamicSwag.java
layout: document
redirect_from:
- /library/library/TemplateDynamicSwag.java
- /library/library/TemplateDynamicSwag.java.html
title: library/TemplateDynamicSwag.java
---
