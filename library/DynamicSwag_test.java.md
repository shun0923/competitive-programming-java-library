---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/DynamicSwag.java
    title: library/DynamicSwag.java
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/queue_operate_all_composite
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 421, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 526, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/queue_operate_all_composite\n\
    \npackage library;\n\nimport library.Solver;\nimport library.Mod;\nimport library.DynamicSwag;\n\
    \npublic class DynamicSwag_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new DynamicSwag_test()); }\n\n\tpublic void solve()\
    \ {\n\t\tlong mask = (1 << 31) - 1;\n\t\tMod md = Mod998.md;\n\t\tint q = ni();\n\
    \t\tDynamicSwag swag = new DynamicSwag(\n\t\t\t1l << 31,\n\t\t\t(ele1, ele2) ->\
    \ md.mul(ele1 >> 31, ele2 >> 31) << 31 | md.mod((ele2 >> 31) * (ele1 & mask) +\
    \ (ele2 & mask)));\n\t\tfor(int i = 0; i < q; i ++) {\n\t\t\tswitch(ni()) {\n\t\
    \t\tcase 0: swag.push(nl() << 31 | nl()); break;\n\t\t\tcase 1: swag.pop(); break;\n\
    \t\t\tcase 2: long p = swag.fold(); prtln(md.mod((p >> 31) * nl() + (p & mask)));\
    \ break;\n\t\t\t}\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Mod.java
  - library/DynamicSwag.java
  isVerificationFile: true
  path: library/DynamicSwag_test.java
  requiredBy: []
  timestamp: '2022-10-29 00:33:53+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/DynamicSwag_test.java
layout: document
redirect_from:
- /verify/library/DynamicSwag_test.java
- /verify/library/DynamicSwag_test.java.html
title: library/DynamicSwag_test.java
---
